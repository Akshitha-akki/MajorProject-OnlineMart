package com.onlinemart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException
{
	private String resourceName;
	private Long fieldName;
	private Object fieldValue;
	public UserNotFoundException(String resourceName, Object fieldValue, Long id) {
		super(String.format("Not Found"));
		this.resourceName = resourceName;
		this.fieldName = id;
		this.fieldValue = fieldValue;
	}
	
	
	
	public UserNotFoundException() {
		super("Not Found");
		// TODO Auto-generated constructor stub
	}



	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public Long getFieldName() {
		return fieldName;
	}
	public void setFieldName(Long fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
}
