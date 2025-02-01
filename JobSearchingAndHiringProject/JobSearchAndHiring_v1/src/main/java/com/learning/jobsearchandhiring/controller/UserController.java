package com.learning.jobsearchandhiring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jobsearchandhiring.model.Role;
import com.learning.jobsearchandhiring.model.Users;
import com.learning.jobsearchandhiring.service.UserService;

@RestController
public class UserController
{
	@Autowired
	private UserService service;
	
	@PostMapping("/addUser")
	public ResponseEntity<Users> addUser(@RequestBody Users user)
	{
		return new ResponseEntity<>(service.addUser(user),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/User/role/{userId}")
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
	
	@PutMapping("/User/ssn/{userId}")
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
