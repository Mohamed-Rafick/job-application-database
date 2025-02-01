package com.learning.jobsearchandhiring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jobsearchandhiring.model.EducationDTO;
import com.learning.jobsearchandhiring.service.EducationService;

@RestController
public class EducationController
{
	@Autowired
	EducationService service;
	
	@PostMapping("/job/apply/page3/{jobSeekerId}")
	public ResponseEntity<String> addEducation(@PathVariable int jobSeekerId, 
											   @RequestBody EducationDTO educationDTO)
	{
		try
		{
			service.addEducation(jobSeekerId, educationDTO.getDegree(), educationDTO.getMajor(), educationDTO.getInstituteName(), educationDTO.getYearOfPassing());
			return new ResponseEntity<>("Education added successfully",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failed to add Education",HttpStatus.EXPECTATION_FAILED);
		}
	}
}
