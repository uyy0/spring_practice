package com.springmvc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Order;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
	
	private Map<Long, Order> listOfOrders;
	private long nextOrderId;
	
	
	
	public OrderRepositoryImpl() {
		System.out.println("OrderRepository 생성자 실행");
		listOfOrders = new HashMap<Long, Order>();
		nextOrderId=2000;
	}

	@Override
	public Long saveOrder(Order order) {
		System.out.println("OrderRepository saveOrder 메서드 실행");
		order.setOrderId(getNextOrderId());
		listOfOrders.put(order.getOrderId(), order);
		return order.getOrderId();
	}
	
	private synchronized long getNextOrderId() {
		System.out.println("OrderRepository getNextOrderId 실행");
		return nextOrderId++;
	}
}
