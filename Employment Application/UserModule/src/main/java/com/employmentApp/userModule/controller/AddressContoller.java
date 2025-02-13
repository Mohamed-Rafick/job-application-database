package com.employmentApp.userModule.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employmentApp.commonLib.dtos.AddressDto;
import com.employmentApp.userModule.model.Address;
import com.employmentApp.userModule.service.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressContoller 
{
	/*
	 * @author Mohamed Rafick
	 */
	@Autowired 
	private AddressService service;
	
	@PostMapping("/add/{userId}")
	public ResponseEntity<AddressDto> addAddress(@PathVariable int userId , @Valid @RequestBody Address address )
	{
		return new ResponseEntity<>(service.addAddress(userId,address),HttpStatus.CREATED);
	}
		
}
