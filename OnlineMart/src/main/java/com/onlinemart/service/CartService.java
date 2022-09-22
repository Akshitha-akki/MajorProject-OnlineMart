package com.onlinemart.service;

import java.util.List;

import com.onlinemart.entity.Cart;
import com.onlinemart.entity.Users;

public interface CartService
{
	//add
	Cart addCart(Cart cart ,int productId,int userId) throws Exception;
	
	//List
	List<Cart> getAllCart();
	
	//GetById
	Cart getCartById(int cartId) throws Exception;
	
	//Update
	Cart updateCart(Cart cart, int cartId) throws Exception;
	
	//Detele
	void deleteCart(int cartId) throws Exception;
}
