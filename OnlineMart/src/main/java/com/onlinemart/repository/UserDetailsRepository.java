package com.onlinemart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemart.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>
{
	
}
