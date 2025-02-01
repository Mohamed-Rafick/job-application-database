package com.learning.jobsearchandhiring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learning.jobsearchandhiring.model.WorkAuthorization;
import com.learning.jobsearchandhiring.service.JobApplicationsService;

@RestController
public class JobApplicationsController
{
	@Autowired
	private JobApplicationsService service;
	
	@PostMapping("job/apply/page1")
	public ResponseEntity<String> applyForJobPage1(@RequestParam("job_id") int jobId,
											 @RequestParam("job_seeker_id") int jobSeekerId,
											 @RequestParam("resume") MultipartFile resume,
											 @RequestParam String experience,
											 @RequestParam WorkAuthorization workAuthorization)
	{
		service.applyForJobPage1(jobId,jobSeekerId,resume,experience,workAuthorization);
		return ResponseEntity.ok("Application Page 1 submitted");
	}
}
