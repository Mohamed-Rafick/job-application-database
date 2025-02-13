package com.employmentApp.jobSeekerModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employmentApp.commonLib.dtos.ApplicationDto;
import com.employmentApp.jobSeekerModule.service.JobApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/application")
public class JobApplicationController
{
	/*
	 * @author Mohamed Rafick
	 */
	@Autowired
	private JobApplicationService service;
	
	@PostMapping("/apply")
	public ResponseEntity<ApplicationDto> apply(@Valid @ModelAttribute ApplicationDto applicationDto,
											 	   @RequestParam("resume") MultipartFile resume)
	{
		
		return new ResponseEntity<>(service.apply(applicationDto,resume),HttpStatus.ACCEPTED);
	} 
}
