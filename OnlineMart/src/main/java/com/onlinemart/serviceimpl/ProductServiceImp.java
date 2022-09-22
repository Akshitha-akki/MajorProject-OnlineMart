package com.onlinemart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemart.entity.Product;
import com.onlinemart.entity.UserDetails;
import com.onlinemart.repository.ProductRepository;
import com.onlinemart.service.ProductService;

@Service
public class ProductServiceImp implements ProductService
{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) 
	{	
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() 
	{
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int productId)
	{
		return productRepository.findById(productId).get();
	}

	@Override
	public Product updateProduct(Product product, int productId) throws Exception 
	{
		Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new Exception("User Id does not exsist"));
		existingProduct.setProduct_name(product.getProduct_name());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return existingProduct;
	}

	@Override
	public void deleteProduct(int productId) throws Exception 
	{
		productRepository.findById(productId).orElseThrow(() -> new Exception("User Id does not exsist"));
		productRepository.deleteById(productId);
	}
	
}
