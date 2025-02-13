package com.employmentApp.jobSeekerModule.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.employmentApp.commonLib.dtos.ApplicationDto;
import com.employmentApp.commonLib.dtos.JobDto;
import com.employmentApp.commonLib.dtos.UserDto;
import com.employmentApp.commonLib.enums.Status;
import com.employmentApp.jobSeekerModule.feignClients.EmployerFeignClient;
import com.employmentApp.jobSeekerModule.feignClients.UserFeignClient;
import com.employmentApp.jobSeekerModule.model.JobApplication;
import com.employmentApp.jobSeekerModule.repository.JobApplicationRepository;


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
	private UserFeignClient userClient;
	
	@Autowired
	private EmployerFeignClient employerClient;
	
	
	@Transactional(rollbackFor = IOException.class)
	public ApplicationDto apply(ApplicationDto applicationDto, MultipartFile resume)
	{
		logger.info("Received data for job application");
		JobDto job=employerClient.getJob(applicationDto.getJobId());
		UserDto jobSeeker=userClient.getUser(applicationDto.getJobSeekerId());
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
			application.setJobSeekerId(applicationDto.getJobSeekerId());
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
