package com.onlinemart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>
{
	
}
