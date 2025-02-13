package com.employmentApp.userModule.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employmentApp.commonLib.dtos.UserDto;
import com.employmentApp.commonLib.enums.Role;
import com.employmentApp.userModule.model.User;
import com.employmentApp.userModule.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController
{
	/*
	 * @author Mohamed Rafick
	 */
	@Autowired
	private UserService service;
	
	@PostMapping("/add")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<>(service.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDto> getUser(@Valid @PathVariable int userId)
	{
		return new ResponseEntity<>(service.getUser(userId),HttpStatus.OK);
	}
	
	@PutMapping("/update/role/{userId}")
	public ResponseEntity<String> updateRole(@PathVariable int userId, @RequestParam Role role) 	
	{
		boolean success=service.updateRole(userId,role);
		if(success)
		{
			return ResponseEntity.ok("Role updated successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or role update failed.");
		}
	}
	
	@PutMapping("/update/ssn/{userId}")
	public ResponseEntity<String> updateSsn(@PathVariable int userId, @RequestBody String ssn )
	{
		boolean updated=service.updateSsn(userId,ssn);
		if(updated)
		{
			return ResponseEntity.ok("SSN updated successfully.");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or SSN update failed.");
		}
	}
	
	
}
