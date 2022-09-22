package com.onlinemart.controller;

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

import com.onlinemart.entity.UserDetails;
import com.onlinemart.exception.UserDetailsNotFound;
import com.onlinemart.service.UserDetailsService;

@RestController
@RequestMapping("/api")
public class UserDetailsController 
{
	@Autowired
	private UserDetailsService detailsService;
	
	//FindById
	@GetMapping("/userdetails/{id}")
	public ResponseEntity<UserDetails> getDetailsById(@PathVariable long id) throws Exception
	{
		return new ResponseEntity<UserDetails>(detailsService.getDetailsById(id),HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/userdetails/{id}")
	public ResponseEntity<UserDetails> updateDetails(@PathVariable long id,@RequestBody UserDetails details) throws Exception
	{
		return new ResponseEntity<UserDetails>(detailsService.updateDetails(details, id),HttpStatus.OK);
	}
		
}
