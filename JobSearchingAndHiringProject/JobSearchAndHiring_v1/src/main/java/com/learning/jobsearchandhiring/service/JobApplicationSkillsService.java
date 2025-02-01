package com.learning.jobsearchandhiring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.jobsearchandhiring.model.JobApplicationSkills;
import com.learning.jobsearchandhiring.repository.JobApplicationSkillsRepository;


@Service
public class JobApplicationSkillsService
{
	 private static final Logger logger = LoggerFactory.getLogger(JobApplicationSkillsService.class);
	
	@Autowired
	JobApplicationSkillsRepository jASRepo;
	
	public void addSkills(int applicationId, int userId, int jobId, List<String> jobApplicationSkills)
	{
		try 
		{
			logger.info("Received request to add skills for applicationId: {}, userId: {}, jobId: {}", applicationId, userId, jobId);
			JobApplicationSkills applicationSkills = new JobApplicationSkills();
			applicationSkills.setApplicationId(applicationId);
			applicationSkills.setUserId(userId);
			applicationSkills.setJobId(jobId);
			applicationSkills.setJsonSkills(jobApplicationSkills);
			jASRepo.save(applicationSkills);
			logger.info("Skills added successfully for applicationId: {}", applicationId);
		}
		catch(Exception e)
		{
			logger.error("Error occurred while adding skills for applicationId: {}", applicationId, e);
            throw new RuntimeException("Failed to save skills. Please try again later.");
		}
	
	}
}
