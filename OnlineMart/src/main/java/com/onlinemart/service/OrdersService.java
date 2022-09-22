package com.onlinemart.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.onlinemart.entity.Orders;

@Component
public interface OrdersService 
{
	Orders addOrders(int userId,int cartId,Orders orders) throws Exception;
	Orders updateOrder(Orders orders,int orderId) throws Exception;
	List<Orders> getAllOrders();
	void deleteOrder(int orderId) throws Exception;
	Orders getOrderById(int orderId) throws Exception;
}
