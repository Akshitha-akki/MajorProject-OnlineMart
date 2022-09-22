package com.onlinemart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
