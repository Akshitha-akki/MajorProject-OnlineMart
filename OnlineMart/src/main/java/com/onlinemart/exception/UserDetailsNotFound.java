package com.onlinemart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserDetailsNotFound extends Exception
{
	Long id;

	public UserDetailsNotFound(Long id) 
	{
		super(String.format("%d id is not Found", id));
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
