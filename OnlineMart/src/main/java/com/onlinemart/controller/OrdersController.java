package com.onlinemart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemart.entity.Orders;
import com.onlinemart.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController 
{
	@Autowired
	private OrdersService ordersService;
	
	//add
	@PostMapping("/{userId}/{cartId}")
	public ResponseEntity<Orders> addOrder(@PathVariable int userId,@PathVariable int cartId, @RequestBody Orders orders) throws Exception 
	{
		return new ResponseEntity<Orders>(ordersService.addOrders(userId,cartId,orders),HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable int orderId, @RequestBody Orders orders) throws Exception 
	{
		return new ResponseEntity<Orders>(ordersService.updateOrder(orders, orderId), HttpStatus.OK);
	}
	
	// get all order details
	@GetMapping("/getAll")
	public List<Orders> getAllOrders() 
	{
		return ordersService.getAllOrders();
	}

	//getOrder details by userId
	@GetMapping("/{userId}")
	public Orders getOrderByUsersId(@PathVariable int userId) throws Exception
	{
		return ordersService.getOrderById(userId);
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable int orderId) throws Exception 
	{
		ordersService.deleteOrder(orderId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	
}
