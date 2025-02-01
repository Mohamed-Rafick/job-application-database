package com.learning.jobsearchandhiring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jobsearchandhiring.model.CertificationDTO;
import com.learning.jobsearchandhiring.service.CertificationService;

@RestController
public class CertificationController 
{
	@Autowired
	CertificationService service;
	
	@PostMapping("/job/apply/page4/{jobSeekerId}")
	public ResponseEntity<String> addCertification(@PathVariable int jobSeekerId,
												   @RequestBody CertificationDTO certificationDTO)
	{
		try 
		{
			service.addCertification(jobSeekerId,certificationDTO.getName(),certificationDTO.getIssuer(),certificationDTO.getIssuedDate(),certificationDTO.getValidUntil());
			return new ResponseEntity<>("Certification added successfully",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failed to add Certification",HttpStatus.EXPECTATION_FAILED);
		}
	}
}
