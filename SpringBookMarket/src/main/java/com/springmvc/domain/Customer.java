package com.springmvc.domain;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = -8923129427599533816L;

	private String customerId;
	private String name;
	private Address address;
	private String phone;

	public Customer() {
		System.out.println("Customer 생성자 실행");
		this.address=new Address();
		System.out.println(customerId);
	}

	public Customer(String customerId, String name) {
		this();
		this.customerId = customerId;
		this.name = name;
		System.out.println("Customer 생성자 실행2");
	}

	public String getCustomerId() {
		System.out.println("getCustomerId 실행");
		return customerId;
	}

	public void setCustomerId(String customerId) {
		System.out.println("setCustomerId 실행");
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		System.out.println("Customer dto hashCode 실행");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Customer dto equals 실행");
		if (this == obj)
			return true;
		if (obj == null) {
			System.out.println("equals false 실행1");
			return false;
		}
		if (getClass() != obj.getClass()) {
			System.out.println("equals false 실행2");
			return false;
		}
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null) {
				System.out.println("equals false 실행3");
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			System.out.println("equals false 실행4");
			return false;
		}
		return true;
	}
	
	
}
