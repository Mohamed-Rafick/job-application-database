package com.employmentApp.jobSeekerModule.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employmentApp.commonLib.dtos.ApplicantSkillsDto;
import com.employmentApp.jobSeekerModule.service.ApplicantSkillsService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/skills")
public class ApplicantSkillsController
{
	/*
	 * @author Mohamed Rafick
	 */
	@Autowired
	ApplicantSkillsService service;
	
	@PostMapping("/add/{userId}")
    public ResponseEntity<ApplicantSkillsDto> addSkills(@PathVariable int userId, 
            								@Valid @RequestBody ApplicantSkillsDto applicantSkillsDto) 
    {
		return new ResponseEntity<>(service.addSkills(userId,applicantSkillsDto),HttpStatus.ACCEPTED);
	} 
}
