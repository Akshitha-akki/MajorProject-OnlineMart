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

import com.onlinemart.entity.Cart;
import com.onlinemart.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	//Add
	@PostMapping("/{productId}/{userId}")
	public ResponseEntity<Cart> addCart(@Valid @RequestBody Cart cart,@PathVariable int productId,@PathVariable int userId) throws Exception
	{
		System.out.println("********");
		return new ResponseEntity<Cart>(cartService.addCart(cart, productId, userId),HttpStatus.OK);
	}
	
	//AllCarts
	@GetMapping("/{productId}")
	public List<Cart> getAllCarts(@PathVariable int productId)
	{
		return cartService.getAllCart();
	}
	
	//getById
	@GetMapping("/{cartid}")
	public ResponseEntity<Cart> getCartById(@PathVariable int cartId) throws Exception
	{
		return new ResponseEntity<Cart>(cartService.getCartById(cartId),HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/{cartId}")
	public ResponseEntity<Cart> updateCart(@Valid @PathVariable int cartId, @RequestBody Cart cart) throws Exception 
	{
		return new ResponseEntity<Cart>(cartService.updateCart(cart ,cartId) , HttpStatus.OK);
	}
	
	//Delete
    @DeleteMapping("/{cartId}")
	public ResponseEntity<Boolean> deleteCart(@PathVariable int cartId) throws Exception 
    {
		cartService.deleteCart(cartId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}	
}
