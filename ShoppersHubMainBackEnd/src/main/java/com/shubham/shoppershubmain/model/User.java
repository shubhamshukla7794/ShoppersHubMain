package com.shubham.shoppershubmain.model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class User 
{
	@Id
	@Pattern(regexp = "^[a-zA-Z0-9_-]{3,20}$")
	private String username;
	
	@NotEmpty(message = "Please enter your password.")
    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;
	
	private String role; //admin|user
	private boolean enabled; //true|false

	@Pattern(regexp = "^[a-zA-Z ]{3,50}$")
	private String customerName;
	
	@Pattern(regexp = "^(\\+\\d{1,2}[- ]?)?\\d{10}$")
	private String mobileNo;
	
    @NotEmpty @Email
	private String emailId;
    
    @Pattern(regexp = "^[a-zA-Z0-9-,() ]{3,250}$")
	private String address;
    
	private Date added_date;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getAdded_date() {
		return added_date;
	}
	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}
	
	
	
	
}
