package com.employmentApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employmentApp.dto.EducationDto;
import com.employmentApp.service.EducationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/education")
public class EducationController
{
	/*
	 * @author Mohamed Rafick
	 */
	@Autowired
	EducationService service;
	
	@PostMapping("/add/{jobSeekerId}")
	public ResponseEntity<EducationDto> addEducation(@PathVariable int jobSeekerId, 
											   		 @Valid @RequestBody EducationDto educationDto)
	{
		return new ResponseEntity<>(service.addEducation(jobSeekerId, educationDto),HttpStatus.ACCEPTED);
	}
		
}
