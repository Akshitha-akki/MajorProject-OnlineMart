package com.onlinemart.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.onlinemart.entity.Users;

@Component
public interface UsersService 
{
	Users UserLogin(String email, String password);
	ResponseEntity<Object> SaveUser(Users user);
	Users getById(int id) throws Exception;
}
