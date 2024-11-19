package com.springmvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.dto.Member;

@Controller
@RequestMapping("/exam03")
public class Example03Controller {
	@GetMapping("/form")
	public String requestForm(Member member) {
		return "webpage09_02";
	}
	@PostMapping("/form")
	public String submitForm(@ModelAttribute("member") Member member, HttpServletRequest request, HttpSession session) {
		String images=request.getServletContext().getRealPath("resources/images");
		System.out.println(images);
		String name=member.getName();
		String filename=member.getImageFile().getOriginalFilename();
		File f = new File(images+"\\"+name+"_"+filename);
		try {
			member.getImageFile().transferTo(f);
		} catch(IOException e){
			e.printStackTrace();
		}
		return "webpage09_submit";
	}
}
