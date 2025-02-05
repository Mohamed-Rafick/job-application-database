package com.employmentApp.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.employmentApp.model.JobApplication;
import com.employmentApp.dto.ApplicationDto;
import com.employmentApp.enums.Status;
import com.employmentApp.enums.WorkAuthorization;
import com.employmentApp.model.Job;
import com.employmentApp.model.User;
import com.employmentApp.repository.JobApplicationRepository;
import com.employmentApp.repository.JobRepository;
import com.employmentApp.repository.UserRepository;

@Service
public class JobApplicationService
{
	/*
	 * @author Mohamed Rafick
	 */
	private static final Logger logger = LoggerFactory.getLogger(JobApplicationService.class);
	
	@Autowired
	JobApplicationRepository jARepo;
	
	@Autowired
	JobRepository jRepo;
	
	@Autowired
	UserRepository uRepo;
	
	@Transactional(rollbackFor = IOException.class)
	public ApplicationDto apply(ApplicationDto applicationDto, MultipartFile resume)
	{
		logger.info("Received data for job application");
		Job job=jRepo.findById(applicationDto.getJobId()).orElse(null);
		User jobSeeker=uRepo.findById(applicationDto.getJobSeekerId()).orElse(null);
		JobApplication application = new JobApplication();
		if (job == null)
		{
			logger.error("Job not found");
            throw new IllegalArgumentException("Job not found.");
        }
		if (jobSeeker == null)
		{
			logger.error("Job Seeker not found");
            throw new IllegalArgumentException("Job Seeker not found.");
        }

		try
		{
			logger.debug("Processing resume file for Job Seeker ID: {}", applicationDto.getJobSeekerId());
			byte resumeBytes[] = resume.getBytes(); 
		
			application.setJobId(job.getJobId());
			application.setJobSeekerId(jobSeeker.getUserId());
			application.setResume(resumeBytes);
			application.setExperience(applicationDto.getExperience());
			application.setWorkAuthorization(applicationDto.getWorkAuth());
			if (application.getStatus() == null)
			{
                application.setStatus(Status.PENDING);
            }
			
			jARepo.save(application);
			logger.info("Application data saved successfully");
			return applicationDto;

		}
		catch(IOException e)
		{
			logger.error("Error while processing resume for Job Seeker ID {}: {}", applicationDto.getJobSeekerId(), e.getMessage());
			throw new RuntimeException("Error while processing data"+e.getMessage(),e);
		}

	}



}
