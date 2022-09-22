package com.onlinemart.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemart.entity.Cart;
import com.onlinemart.entity.Orders;
import com.onlinemart.entity.Users;
import com.onlinemart.repository.OrdersRepository;
import com.onlinemart.repository.ProductRepository;
import com.onlinemart.service.CartService;
import com.onlinemart.service.OrdersService;
import com.onlinemart.service.UsersService;

@Service
public class OrdersServiceImp implements OrdersService
{
	@Autowired
	public OrdersRepository ordersRepository;
	
	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public CartService cartService;
	
	@Autowired
	private UsersService usersService;

	@Override
	public Orders addOrders(int userId, int cartId,Orders orders) throws Exception 
	{
		Cart cart = cartService.getCartById(cartId);
		orders.setCart(cart);
		Users users = usersService.getById(userId);
		orders.setTotalPrice(orders.getMrpPrice() * cart.getQuantity());
		orders.setPaymentStatus(orders.getPaymentStatus());
		orders.setOrderStatus(orders.getOrderStatus());
		orders.setOrdered_Date(orders.getOrdered_Date());
		orders.setMrpPrice(orders.getMrpPrice());
		orders.setQuantity(orders.getQuantity());
		orders.setUser(users);
		return ordersRepository.save(orders);
	}

	@Override
	public Orders getOrderById(int orderId) throws Exception 
	{
		return ordersRepository.findById(orderId).orElseThrow(() -> new Exception("Not Found"));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Orders> getAllOrders() 
	{
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date= new java.util.Date();
		String currentDate=sdf.format(date);
		String [] array=currentDate.split("/");
		int month=Integer.parseInt(array[0]);
		int day=Integer.parseInt(array[1]);
		int year=Integer.parseInt(array[2]);
		java.util.Date d=new java.util.Date(month,day,year);
		System.out.println(d);
		List<Orders> orders=ordersRepository.findAll();
		System.out.println(orders);
		return ordersRepository.findAll();
	   }

	@Override
	public Orders updateOrder(Orders orders, int orderId) throws Exception 
	{
		Orders existingOrders = ordersRepository.findById(orderId).orElseThrow(() -> new Exception("Not Found"));
		existingOrders.setTotalPrice(orders.getMrpPrice());
		existingOrders.setPaymentStatus(orders.getPaymentStatus());
		existingOrders.setMrpPrice(orders.getMrpPrice());
		existingOrders.setOrderStatus(orders.getOrderStatus());
		existingOrders.setUser(orders.getUser());
		ordersRepository.save(existingOrders);
		return existingOrders;
	}
	
	@Override
	public void deleteOrder(int orderId) throws Exception 
	{
		ordersRepository.findById(orderId).orElseThrow(() -> new Exception("Not Found"));
		ordersRepository.deleteById(orderId);
	}	
}
