package com.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired //bookservice도 컴포넌트 스캔 되어 있어야 함
	private BookService bookService;
	
	@GetMapping
	public String requestBookList(Model model) {
		System.out.println("BookController의 requestBookList 실행");
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList",list);
		return "books";
	}
	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		System.out.println("BookController의 requestAllBooks 실행");
		ModelAndView modelAndView = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		modelAndView.addObject("bookList",list);
		modelAndView.setViewName("books");
		return modelAndView;
	}
	
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		System.out.println("requestBooksByCategory 실행. 파라미터 category : "+ bookCategory);
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList",booksByCategory);
		return "books";
	}
	
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model) {
		System.out.println("requestBooksByFilter 실행. 받아온 파라미터 : " + bookFilter);
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList",booksByFilter);
		return "books";
	}
	
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		System.out.println("requestBookById 실행. 받은 파라미터 : "+bookId);
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book",bookById);
		return "book";
	}
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {
		return "addBook";
	}
	@PostMapping("/add")
	public String submitAddNewBook(@ModelAttribute("NewBook") Book book, HttpServletRequest request) {
		MultipartFile bookImage = book.getBookImage();
		
		String saveName=bookImage.getOriginalFilename();
		String images=request.getServletContext().getRealPath("resources/images");
		System.out.println(images);
		File saveFile = new File(images+"\\"+saveName);
		if(bookImage!=null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(saveFile);
			} catch(Exception e) {
				throw new RuntimeException("도서 이미지 업로드가 실패하였습니다.", e);
			}
		}
		bookService.setNewBook(book);
		return "redirect:/books";
	}
	public void addAttributes(Model model) {
		model.addAttribute("addTitle","신규 도서 등록");
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId","name","unitPrice", "author",
				"description","publisher","category","unitsInStock",
				"totalPages","releaseDate","condition","bookImage");
	}
}
