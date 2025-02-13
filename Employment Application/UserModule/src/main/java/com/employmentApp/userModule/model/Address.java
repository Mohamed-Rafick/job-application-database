package com.employmentApp.userModule.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="address")
public class Address
{
	/*
	 * @author Mohamed Rafick
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;   
	
	@NotNull(message = "User ID cannot be null")
    @Column(name = "user_id", nullable = false)
    private int userId;
	
	@NotNull(message="address_line1 cannot be null ")
	@NotEmpty(message="address_line1 cannot be empty")
	@Column(name="address_line1", nullable=false)
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
	@NotNull(message="city cannot be null")
	@NotEmpty(message="city cannot be empty")
	@Column(name="city", nullable=false)
	private String city;
	
	
	@NotNull(message="state cannot be null")
	@NotEmpty(message="state cannot be empty")
	@Column(name="state", nullable=false)
	private String state;
	
	@NotNull(message="zip cannot be null")
	@NotEmpty(message="zip canot be empty")
	@Column(name="zip", nullable=false)
	private String zip;
	
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


	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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
