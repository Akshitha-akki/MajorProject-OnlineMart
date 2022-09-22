package com.onlinemart.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.onlinemart.entity.Payment;

@Component
public interface PaymentService 
{
	Payment addPayment(Payment payment,int orderId,int userId)throws Exception;
	List<Payment> getAllPayments();
	Payment getPaymentById(int paymentId)throws Exception;
	void deletePayment(int paymentId)throws Exception;
}
