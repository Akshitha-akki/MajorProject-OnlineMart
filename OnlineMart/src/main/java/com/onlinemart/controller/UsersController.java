package com.onlinemart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemart.entity.Users;
import com.onlinemart.service.UsersService;

@RestController
@RequestMapping("/api")
public class UsersController 
{
	@Autowired(required=true)
	private UsersService userService;
	
	//SignUp
	@PostMapping("/SignUp")
	public ResponseEntity<Object> SignUp(@Valid @RequestBody Users user)
	{
		return userService.SaveUser(user);
	}
	
	//Signin
	@PostMapping("/Signin")
	public HttpStatus LoginUser(@RequestBody Users user)throws Exception
	{
		String tempEmail = user.getEmail();
		String tempPassword = user.getPassword();
		
		Users obj = null;
		if(tempEmail != null && tempPassword != null)
		{
			obj = userService.UserLogin(tempEmail, tempPassword);
		}
		if(obj == null)
		{
			throw new Exception("User does not exist");
		}
		return HttpStatus.OK;
	}
	
	
}
