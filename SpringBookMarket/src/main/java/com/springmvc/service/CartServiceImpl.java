package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Cart;
import com.springmvc.exception.CartException;
import com.springmvc.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;
	@Override
	public Cart create(Cart cart) {
		System.out.println("CartServiceimpl 생성자");
		// TODO Auto-generated method stub
		return cartRepository.creat(cart);
	}

	@Override
	public Cart read(String cartId) {
		// TODO Auto-generated method stub
		return cartRepository.read(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.update(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		cartRepository.delete(cartId);
	}

	
	public Cart validateCart(String cartId) {
		System.out.println("CartServiceImple validateCart 메서드 실행");
		Cart cart = cartRepository.read(cartId);
		if(cart == null || cart.getCartItems().size() == 0) {
			System.out.println("CartServiceImple validateCart 메서드 예외 발생");
			throw new CartException(cartId);
		}
		System.out.println("CartServiceImple validateCart 메서드 완료");
		return cart;
	}
}
