package com.learning.jobsearchandhiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.learning.jobsearchandhiring.service.JobApplicationSkillsService;


@RestController
public class JobApplicationSkillsController
{
	@Autowired
	JobApplicationSkillsService service;
	
	@PostMapping("/job/apply/page2/{userId}/{jobId}/{applicationId}")
    public ResponseEntity<String> addSkills(
            @PathVariable int userId, 
            @PathVariable int jobId, 
            @PathVariable int applicationId,
            @RequestBody List<String> skills) 
    {
	    try 
	    {
	        service.addSkills(applicationId, userId, jobId, skills);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Skills added successfully for applicationId: " + applicationId);
	    } 
	    catch (Exception e) 
	    {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add skills. Please try again later.");
	    }
    }
}
