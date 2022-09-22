package com.onlinemart.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemart.entity.Orders;
import com.onlinemart.entity.Payment;
import com.onlinemart.entity.Product;
import com.onlinemart.entity.Users;
import com.onlinemart.repository.OrdersRepository;
import com.onlinemart.repository.PaymentRepository;
import com.onlinemart.service.OrdersService;
import com.onlinemart.service.PaymentService;
import com.onlinemart.service.ProductService;
import com.onlinemart.service.UsersService;

@Service
public class PaymentServiceImp implements PaymentService
{
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private OrdersService ordersService;
	
    public Payment addPayment(Payment payment,int orderId,int userId) throws Exception
    {	
    	Orders order = ordersRepository.findById(orderId).orElseThrow(() -> new Exception("Not Found"));
		payment.setOrderId(orderId);
		payment.setTotalPrice(order.getTotalPrice());
		payment.setPaidDate(LocalDate.now());
		payment.setPaidAmount(order.getTotalPrice());
		if (payment.getTotalPrice() == payment.getPaidAmount()) 
		{
			order.setPaymentStatus("PAID");
			order.setOrderStatus("Delivered");
		} 
		else 
		{
			order.setPaymentStatus("NOT-PAID");
			order.setOrderStatus("payment pending");
		}
	     Users users = usersService.getById(userId);
		 payment.setUser(users);
		 return paymentRepository.save(payment);
    }

	@Override
	public List<Payment> getAllPayments() 
	{
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(int paymentId) throws Exception
	{
		return paymentRepository.findById(paymentId).orElseThrow(()-> new Exception("Not found"));
	}

	@Override
	public void deletePayment(int paymentId) throws Exception
	{
		paymentRepository.findById(paymentId).orElseThrow(()-> new Exception("Not found"));
		paymentRepository.deleteById(paymentId);
	}
}
