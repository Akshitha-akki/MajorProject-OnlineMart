package com.onlinemart.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.onlinemart.entity.Product;
import com.onlinemart.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	//Add
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product)
	{
		return this.productService.addProduct(product);
	}
	
	//ListOfProduct
	@GetMapping("/list")
	public List<Product> getProduct()
	{
		return this.productService.getAllProduct();
	}
	
	//getById
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@Valid @PathVariable int id,@RequestBody Product product) throws Exception
	{
		return new ResponseEntity<Product>(productService.updateProduct(product, id),HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable int productId) throws Exception 
	{
		productService.deleteProduct(productId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
	
	
	
	
	
}
