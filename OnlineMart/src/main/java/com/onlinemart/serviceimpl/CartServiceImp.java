package com.onlinemart.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemart.entity.Cart;
import com.onlinemart.entity.Product;
import com.onlinemart.entity.Users;
import com.onlinemart.repository.CartRepository;
import com.onlinemart.service.CartService;
import com.onlinemart.service.ProductService;
import com.onlinemart.service.UsersService;

@Service
public class CartServiceImp implements CartService
{
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UsersService usersSerivce;

	@Override
	public Cart addCart(Cart cart, int productId, int userId) throws Exception 
	{
		Product product =productService.getProductById(productId);
		Users customer = usersSerivce.getById(userId);
		product.setQuantity(product.getQuantity()-cart.getQuantity());
		cart.setProduct(product);
		cart.setPrice(product.getPrice());
		cart.setUser(customer);
		 System.out.println("product"+product);
		 System.out.println("customer"+customer);
		 System.out.println("cart"+cart);
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getAllCart() 
	{
		return cartRepository.findAll();
	}

	@Override
	public Cart getCartById(int cartId) throws Exception 
	{
		return cartRepository.findById(cartId).orElseThrow(()->new Exception("Not Found carId"));
	}

	@Override
	public Cart updateCart(Cart cart, int cartId) throws Exception 
	{
		Cart existingCart = cartRepository.findById(cartId).orElseThrow(()->new Exception("Not Found"));
		existingCart.setQuantity(cart.getQuantity());
		existingCart.setPrice(cart.getPrice());
		existingCart.setProduct(cart.getProduct());
		existingCart.setUser(cart.getUser());
		cartRepository.save(existingCart);
		return existingCart;
	}

	@Override
	public void deleteCart(int cartId) throws Exception 
	{
		cartRepository.findById(cartId).orElseThrow(()->new Exception("Not Found"));
		cartRepository.deleteById(cartId);
	}
	
}
