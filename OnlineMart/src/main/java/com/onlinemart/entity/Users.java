package com.onlinemart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Users 
{
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@NotEmpty
	@Size(message = "Please use the validate email")
	@Email      
	public String email;
	
	@NotNull
	@Size(max = 8 ,message = "Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp ="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EnumRole role;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserDetails userdetails;
	
	public Users() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EnumRole getRole() {
		return role;
	}

	public void setRole(EnumRole role) {
		this.role = role;
	}

	public UserDetails getUserDetails() {
		return userdetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userdetails = userDetails;
	}
}
