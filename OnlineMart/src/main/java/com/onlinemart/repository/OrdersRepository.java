package com.onlinemart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemart.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>
{
	
}
