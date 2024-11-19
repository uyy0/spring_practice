package com.springmvc.dto;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String name;
	private MultipartFile imageFile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String name, MultipartFile imageFile) {
		super();
		this.name = name;
		this.imageFile = imageFile;
	}
}
