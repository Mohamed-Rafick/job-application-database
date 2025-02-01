package com.learning.jobsearchandhiring.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.learning.jobsearchandhiring.model.JobApplicationSkills;
import com.learning.jobsearchandhiring.model.JobApplications;
import com.learning.jobsearchandhiring.model.Jobs;
import com.learning.jobsearchandhiring.model.Status;
import com.learning.jobsearchandhiring.model.Users;
import com.learning.jobsearchandhiring.model.WorkAuthorization;
import com.learning.jobsearchandhiring.repository.JobApplicationsRepository;
import com.learning.jobsearchandhiring.repository.JobsRepository;
import com.learning.jobsearchandhiring.repository.UserRepository;

@Service
public class JobApplicationsService
{
	private static final Logger logger = LoggerFactory.getLogger(JobApplicationsService.class);
	
	@Autowired
	JobApplicationsRepository jARepo;
	
	@Autowired
	JobsRepository jRepo;
	
	@Autowired
	UserRepository uRepo;
	
	@Transactional(rollbackFor = IOException.class)
	public void applyForJobPage1(int jobId, int jobSeekerId, MultipartFile resume, String experience, WorkAuthorization workAuthorization)
	{
		logger.info("Starting job application page 1");
		Jobs job=jRepo.findById(jobId).orElse(null);
		Users jobSeeker=uRepo.findById(jobSeekerId).orElse(null);
		JobApplications application = new JobApplications();
		if (job == null || jobSeeker == null)
		{
			logger.error("Job or JobSeeker not found");
            throw new IllegalArgumentException("Job or Job Seeker not found.");
        }

		try
		{
			logger.debug("Processing resume file for Job Seeker ID: {}", jobSeekerId);
			byte resumeBytes[] = resume.getBytes(); 
		
			application.setJob(job);
			application.setJobSeeker(jobSeeker);
			application.setResume(resumeBytes);
			application.setExperience(experience);
			application.setWorkAuthorization(workAuthorization);
			if (application.getStatus() == null)
			{
                application.setStatus(Status.PENDING);
            }
			
			jARepo.save(application);
			logger.info("Application page 1 saved successfully");

		}
		catch(IOException e)
		{
			logger.error("Error while processing resume for Job Seeker ID {}: {}", jobSeekerId, e.getMessage());
			throw new RuntimeException("Error while processing resume file"+e.getMessage(),e);
		}

	}



}
