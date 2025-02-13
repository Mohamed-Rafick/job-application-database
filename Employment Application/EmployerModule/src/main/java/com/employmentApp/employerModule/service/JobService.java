package com.employmentApp.employerModule.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employmentApp.commonLib.dtos.JobDto;
import com.employmentApp.commonLib.dtos.UserDto;
import com.employmentApp.employerModule.feignClients.UserFeignClient;
import com.employmentApp.employerModule.model.Job;
import com.employmentApp.employerModule.repository.JobRepository;



@Service
public class JobService
{
	/*
	 * @author Mohamed Rafick
	 */
	private static final Logger logger = LoggerFactory.getLogger(JobService.class);
	
	@Autowired
	private UserFeignClient userClient;
	
	@Autowired
	private JobRepository jRepo;
	
	
	public JobDto addJob(int userId, Job job) 
	{
		logger.info("Attempting a add a job: {}", job.getPosition());
		//User user = uRepo.findById(userId).orElse(null);
		UserDto userDto = userClient.getUser(userId);
        //if (user==null)
		if(userDto==null)
        {
            throw new NoSuchElementException("User with ID " + userId + " not found.");
        }
        
        job.setUserId(userId);
        try
		{
		
			Job savedJob = jRepo.save(job);
	        
	        JobDto jobDto = new JobDto();
	        
	        jobDto.setJobId(savedJob.getJobId());
	        jobDto.setPosition(savedJob.getPosition());
	        jobDto.setCompany(savedJob.getCompany());
	        jobDto.setExperience(savedJob.getExperience());
	        jobDto.setSkills(savedJob.getSkills());
	        jobDto.setSalary(savedJob.getSalary());
	        jobDto.setLocation(savedJob.getLocation());
	        jobDto.setEducation(savedJob.getEducation());
	        jobDto.setJobType(savedJob.getJobType());
	        jobDto.setLastDate(savedJob.getLastDate());
	        jobDto.setHiringDone(savedJob.isHiringDone());
	        jobDto.setDescription(savedJob.getDescription());
	        jobDto.setUsername(userDto.getUserName());
	        jobDto.setEmail(userDto.getEmail());
	        logger.info("Job added successfully");
			return jobDto;
		}
		
		catch(Exception e)
		{
			logger.error("An error occured while adding the job {}", e.getMessage(), e);
			throw new RuntimeException("An error occured while adding the job.");
		}
		
		
	}

	public JobDto getJob(int jobId)
	{
		JobDto jobDto = new JobDto();
		try
		{
			logger.info("Fetching job with jobId: {}", jobId);
			Job job=jRepo.findById(jobId).orElse(null);
			
			if (job==null)
			{
	            logger.error("Job with jobId {} not found", jobId);
	            throw new NoSuchElementException("Job not found with ID: " + jobId);
	        }
				int userId=job.getUserId();
				UserDto userDto = userClient.getUser(userId);
			
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
			    jobDto.setUsername(userDto.getUserName());
			    jobDto.setEmail(userDto.getEmail());
			    
			    logger.info("Job with jobId {} successfully retrieved", jobId);
			    return jobDto;
		}
		catch (Exception e)
		{
            logger.error("An unexpected error occurred while fetching job with jobId: {}", jobId, e);
            throw new RuntimeException("An unexpected error occurred while processing the job with ID: " + jobId, e);
        }
		
		
	}

}
