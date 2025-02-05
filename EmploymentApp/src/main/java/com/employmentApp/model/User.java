package com.employmentApp.model;

import java.time.LocalDateTime;

import com.employmentApp.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User
{
	/*
	 * @author Mohamed Rafick
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message="user_id cannot be null")
	@NotEmpty(message="user_id cannot be empty")
	private int userId;
	
	@NotNull(message="user_name cannot be null")
	@NotEmpty(message="user_name cannot be empty")
	@Column(name="user_name", unique=true, nullable=false)
	private String userName;
	
	@NotNull(message="first_name cannot be null")
	@NotEmpty(message="first_name cannot be empty")
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@NotNull(message="last_name cannot be null")
	@NotEmpty(message="last_name cannot be empty")
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Email(message="this email is not valid")
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@NotNull(message="password cannot be null")
	@NotEmpty(message="password cannot be empty")
	@Column(name="password", nullable=false)
	private String password;
	

	@Column(name="ssn", unique=true)
	private String ssn;
	
	@NotNull(message="phone_number cannot be null")
	@NotEmpty(message="phone_number cannot be empty")
	@Column(name="phone_number", nullable=false)
	private String phoneNumber;
	
	@NotEmpty(message="role cannot be empty")
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name="created_on", updatable=false)
	private LocalDateTime createdOn;
	
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
	
	  @PrePersist
	  public void prePersist()
	  {
		 if (this.createdOn == null)
	     {
	    	 this.createdOn = LocalDateTime.now();
	     }
	     this.updatedOn = LocalDateTime.now();
	  }

	  @PreUpdate
	  public void preUpdate() 
	  {
		  this.updatedOn = LocalDateTime.now();
	  }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	
}
