package com.onlinemart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemart.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
