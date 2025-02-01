package com.learning.jobsearchandhiring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jobsearchandhiring.model.Address;
import com.learning.jobsearchandhiring.service.AddressService;

@RestController
public class AddressContoller 
{
	
	@Autowired 
	private AddressService service;
	
	@PostMapping("/address/add/{userId}")
	public ResponseEntity<String> addAddress(@PathVariable int userId , @RequestBody Address address )
	{
	
		boolean isAdded=service.addAddress(userId,address);
		if(isAdded)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body("Address added successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address could not be added");
		}
	}
		
}
