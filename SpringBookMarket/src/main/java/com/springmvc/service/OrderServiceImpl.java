package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.domain.Order;
import com.springmvc.repository.BookRepository;
import com.springmvc.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartService cartService;
	
	

	@Override
	public void confirmOrder(String bookId, long quantity) {
		System.out.println("Order Service Impl confirmOrder 메서드 실행");
		Book bookById = bookRepository.getBookById(bookId);
		if(bookById.getUnitsInStock()<quantity) {
			throw new IllegalArgumentException("품절입니다. 사용 가능한 재고 수 : "+bookById.getUnitsInStock());
		}
		bookById.setUnitsInStock(bookById.getUnitsInStock()-quantity);
	}

	@Override
	public Long saveOrder(Order order) {
		System.out.println("Order Servicd Impl saveOrder 메서드 실행");
		Long orderId = orderRepository.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		return orderId;
	}

}
