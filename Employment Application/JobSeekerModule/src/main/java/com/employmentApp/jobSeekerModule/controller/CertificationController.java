package com.employmentApp.jobSeekerModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employmentApp.commonLib.dtos.CertificationDto;
import com.employmentApp.jobSeekerModule.service.CertificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/certificate")
public class CertificationController 
{
	/*
	 * @author Mohamed Rafick
	 */
	@Autowired
	CertificationService service;
	
	@PostMapping("/add/{jobSeekerId}")
	public ResponseEntity<CertificationDto> addCertification(@PathVariable int jobSeekerId,
												   			 @Valid @RequestBody CertificationDto certificationDto)
	{
		return new ResponseEntity<>(service.addCertification(jobSeekerId,certificationDto),HttpStatus.ACCEPTED);
	}
}
