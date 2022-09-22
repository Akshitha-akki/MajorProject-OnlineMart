package com.onlinemart.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "generator1", sequenceName = "gen1", initialValue = 1000)
public class UserDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
	private long userdetails_Id;
	
	@Column(length = 15, name="first_name")
	@NotEmpty
	@Size(min=3 , message="firstName must contain atleast 3 characters")
	private String firstName;
	
	@Column(length = 15, name="last_name")
	@NotEmpty
	@Size(min=3 , message="lastName must contain atleast 3 characters")
	private String lastName;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="phone_number")
	@NotEmpty
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;
	
	@Column(length = 15,name="district")
	@NotEmpty
	@Size(min=3 , message="district must contain atleast 3 characters")
    private String district;
	
	@Column(length = 15,name="state")
	@NotEmpty
	@Size(min=3 , message="district must contain atleast 3 characters")
    private String state;
	
	@Column(name="zip_code")
	@NotEmpty
	@Size(min=6 ,max=6, message="zipCode must contain 6 digits")
	private String zipCode;
	
	@Column(name="email_id",unique = true)
	@NotEmpty
	@Email(message="Email  is not valid!")
	public String emailID;
	
	@Column(length = 8,name="gender")
	@NotEmpty
	@Size(min=4 , message="gender must contain atleast 4 characters")
	public String gender;
	
	@Column(name="password")
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String password;
	
	public UserDetails() {
		super();
	}

	@Override
	public String toString() {
		return "UserDetails [Id=" + userdetails_Id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", phoneNumber=" + phoneNumber + ", district=" + district + ", state=" + state
				+ ", zipCode=" + zipCode + ", emailID=" + emailID + ", gender=" + gender + ", password=" + password
				+ "]";
	}
	
	public long getId() {
		return userdetails_Id;
	}

	public void setId(long id) {
		userdetails_Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
