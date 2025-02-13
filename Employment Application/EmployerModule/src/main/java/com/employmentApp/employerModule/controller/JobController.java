package com.employmentApp.employerModule.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employmentApp.commonLib.dtos.JobDto;
import com.employmentApp.employerModule.model.Job;
import com.employmentApp.employerModule.service.JobService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController
{
	/*
	 * @author Mohamed Rafick
	 */
	@Autowired
	private JobService service;
	
	@PostMapping("/add/{userId}")
	public ResponseEntity<JobDto> addJob(@PathVariable int userId, @Valid @RequestBody Job job)
	{
	    if (job.getSkills() == null) 
	    {
	        job.setSkills(new ArrayList<>());
	    }
		return new ResponseEntity<>(service.addJob(userId,job),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{jobId}")
	public ResponseEntity<JobDto> getJob(@PathVariable int jobId)
	{
		return new ResponseEntity<>(service.getJob(jobId),HttpStatus.OK);
		
	}
	
}
