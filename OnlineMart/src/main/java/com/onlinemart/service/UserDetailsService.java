package com.onlinemart.service;

import org.springframework.stereotype.Component;

import com.onlinemart.entity.UserDetails;

@Component
public interface UserDetailsService 
{
	UserDetails getDetailsById(Long id) throws Exception;
	public UserDetails updateDetails(UserDetails details ,long id) throws Exception;
}
