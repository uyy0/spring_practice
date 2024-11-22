package com.springmvc.repository;

import com.springmvc.domain.Cart;

public interface CartRepository {
	Cart creat(Cart cart);
	Cart read(String cartId);
	void update(String cartId, Cart cart);
	void delete(String cartId);
}
