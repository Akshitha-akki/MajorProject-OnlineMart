package com.onlinemart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemart.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>
{
	public Users findByEmailAndPassword(String email, String password);
}
