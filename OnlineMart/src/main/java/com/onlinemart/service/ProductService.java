package com.onlinemart.service;

import java.util.List;

import com.onlinemart.entity.Payment;
import com.onlinemart.entity.Product;

public interface ProductService 
{
	//Add
	Product addProduct(Product product);
	
	//getAllProduct
	List<Product> getAllProduct();
	
	//Get by Id
	Product getProductById(int productId);
	
	//Update
	Product updateProduct(Product product,int productId) throws Exception;
	
	//Delete
	void deleteProduct(int productId) throws Exception;
}
