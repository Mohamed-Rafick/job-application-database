package com.learning.jobsearchandhiring.service;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.jobsearchandhiring.model.JobDTO;
import com.learning.jobsearchandhiring.model.Jobs;
import com.learning.jobsearchandhiring.model.Users;
import com.learning.jobsearchandhiring.repository.JobsRepository;
import com.learning.jobsearchandhiring.repository.UserRepository;

@Service
public class JobsService
{
	private static final Logger logger = LoggerFactory.getLogger(JobsService.class);
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private JobsRepository jRepo;
	
	
	public Jobs addJob(int userId, Jobs job) 
	{
		logger.info("Attempting a add a job: {}", job.getPosition());
		if(job.getPosition()==null || job.getPosition().isEmpty())
		{
			logger.error("Position cannot be empty.");
			throw new IllegalArgumentException("Position cannot be empty.");
		}
		if(job.getCompany()==null || job.getCompany().isEmpty())
		{
			logger.error("Company cannot be empty.");
			throw new IllegalArgumentException("Company cannot be empty.");
		}
		if(job.getSkills()==null || job.getSkills().isEmpty())
		{
			logger.error("Skills cannot be empty.");
			throw new IllegalArgumentException("Skills cannot be empty.");
		}
		if(job.getJobType()==null)
		{
			logger.error("Job type cannot be empty.");
			throw new IllegalArgumentException("Job type cannot be empty.");
		}
		if(job.getLastDate()==null)
		{
			logger.error("Last date cannot be empty.");
			throw new IllegalArgumentException("Last date cannot be empty.");
		}
		Users user=uRepo.findById(userId).orElse(null);
		if(user==null)
		{
			logger.error("User with Id {} not found", userId);
			throw new NoSuchElementException("User not found with Id "+userId);
		}
		job.setUser(user);
		try
		{
			Jobs createdJob=jRepo.save(job);
			logger.info("Job added successfully");
			return createdJob;
		}
		catch(Exception e)
		{
			logger.error("An error occured while adding the job {}", e.getMessage(), e);
			throw new RuntimeException("An error occured while adding the job.");
		}
		
		
	}

	public JobDTO getJob(int jobId)
	{
		JobDTO jobDto = new JobDTO();
		try
		{
			logger.info("Fetching job with jobId: {}", jobId);
			Jobs job=jRepo.findById(jobId).orElse(null);
			
			if (job==null)
			{
	            logger.error("Job with jobId {} not found", jobId);
	            throw new NoSuchElementException("Job not found with ID: " + jobId);
	        }
			
			
				jobDto.setJobId(job.getJobId());
				jobDto.setPosition(job.getPosition());
			    jobDto.setCompany(job.getCompany());
			    jobDto.setExperience(job.getExperience());
			    jobDto.setSkills(job.getSkills()); 
			    jobDto.setSalary(job.getSalary());
			    jobDto.setLocation(job.getLocation());
			    jobDto.setEducation(job.getEducation());
			    jobDto.setJobType(job.getJobType());
			    jobDto.setCreatedOn(job.getCreatedOn());
			    jobDto.setLastDate(job.getLastDate());
			    jobDto.setHiringDone(job.isHiringDone());
			    jobDto.setUpdatedOn(job.getUpdatedOn());
			    jobDto.setDescription(job.getDescription());
			    
			
			    jobDto.setUserId(job.getUser().getUserId());
			    jobDto.setUsername(job.getUser().getUserName());
			    jobDto.setEmail(job.getUser().getEmail());
			    
			    logger.info("Job with jobId {} successfully retrieved", jobId);
		}
		catch (Exception e)
		{
            logger.error("An unexpected error occurred while fetching job with jobId: {}", jobId, e);
            throw new RuntimeException("An unexpected error occurred while processing the job with ID: " + jobId, e);
        }
		return jobDto;
		
	}

}
