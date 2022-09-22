package com.onlinemart.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemart.entity.UserDetails;
import com.onlinemart.exception.UserDetailsNotFound;
import com.onlinemart.exception.UserNotFoundException;
import com.onlinemart.repository.UserDetailsRepository;
import com.onlinemart.service.UserDetailsService;

@Service
public class UserDetailsServiceImp implements UserDetailsService
{
	@Autowired
	private UserDetailsRepository detailsRepository;

	public UserDetails getDetailsById(Long id) throws Exception
	{
		return detailsRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
	}

	//Update
	@Override
	public UserDetails updateDetails(UserDetails details, long id) throws Exception 
	{
		UserDetails existsingDetails = detailsRepository.findById(id).orElseThrow(() -> new Exception("User Id does not exsist"));
		existsingDetails.setFirstName(details.getFirstName());
		existsingDetails.setLastName(details.getLastName());
		existsingDetails.setDateOfBirth(details.getDateOfBirth());
		existsingDetails.setPhoneNumber(details.getPhoneNumber());
		existsingDetails.setDistrict(details.getDistrict());
		existsingDetails.setState(details.getState());
		existsingDetails.setZipCode(details.getZipCode());
		existsingDetails.setEmailID(details.getEmailID());
		existsingDetails.setGender(details.getGender());
		detailsRepository.save(existsingDetails);
		return existsingDetails;
	}
}
