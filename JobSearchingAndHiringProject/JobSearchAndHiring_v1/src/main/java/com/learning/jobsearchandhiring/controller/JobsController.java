package com.learning.jobsearchandhiring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jobsearchandhiring.model.JobDTO;
import com.learning.jobsearchandhiring.model.Jobs;
import com.learning.jobsearchandhiring.service.JobsService;

@RestController
public class JobsController
{
	@Autowired
	private JobsService service;
	
	@PostMapping("/addJob/{userId}")
	public ResponseEntity<Jobs> addJob(@PathVariable int userId, @RequestBody Jobs job)
	{
		// Log the job object to check if skills are being received correctly
	    System.out.println("Received Job: " + job.getSkills());
	    if (job.getSkills() == null) 
	    {
	        job.setSkills(new ArrayList<>());
	    }
		return new ResponseEntity<>(service.addJob(userId,job),HttpStatus.CREATED);
	}
	
	@GetMapping("/jobs/{jobId}")
	public ResponseEntity<JobDTO> getJob(@PathVariable int jobId)
	{
		return new ResponseEntity<>(service.getJob(jobId),HttpStatus.OK);
		
	}
	
}
