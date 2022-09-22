package com.onlinemart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemart.entity.Payment;
import com.onlinemart.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController 
{
	@Autowired
	private PaymentService paymentService;
	
	//add
	@PostMapping("/{orderId}/{userId}")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment,@PathVariable int orderId,@PathVariable int userId)throws Exception
	{
		return new ResponseEntity<Payment>(paymentService.addPayment(payment, orderId, userId),HttpStatus.CREATED);
	}
	
	//getting list of payements
	@GetMapping("/getAll")
	public List<Payment> getAllPayments() 
	{
		return paymentService.getAllPayments();
	}

	//get payement by payement id(for receipt)
	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable int paymentId) throws Exception
	{
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
	}

	//delete payement
	@DeleteMapping("/{paymentId}")
	public ResponseEntity<Boolean> deletePayment(@PathVariable int paymentId) throws Exception
	{
		paymentService.deletePayment(paymentId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
