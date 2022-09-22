package com.onlinemart.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlinemart.entity.Users;
import com.onlinemart.repository.UsersRepository;
import com.onlinemart.service.UsersService;

@Service
public class UsersServiceImp implements UsersService
{
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public Users UserLogin(String email , String password) 
	{
		return userRepository.findByEmailAndPassword(email, password);	
	}
	
	@Override
	public ResponseEntity<Object> SaveUser(Users user) 
	{	
		Users user1 = new Users();
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setRole(user.getRole());
		user1.setUserDetails(user.getUserDetails());
		//User saveduser = userRepository.save(user1);
		
		/*User user1 = new User();
		user1.setEmail(user.getEmail());*/
		Users saveduser = userRepository.save(user1);
		
		if(userRepository.findById(saveduser.getId()).isPresent())
			return ResponseEntity.ok().body("SignUp Successfull");
		else
			return ResponseEntity.unprocessableEntity().body("Failed to Create the User");
	}

	@Override
	public Users getById(int id) throws Exception 
	{
		return userRepository.findById(id).orElseThrow(() -> new Exception("Not Found userId"));
	}
}
