package com.learning.jobsearchandhiring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.jobsearchandhiring.model.Education;
import com.learning.jobsearchandhiring.repository.EducationRepository;

@Service
public class EducationService
{
	private static final Logger logger = LoggerFactory.getLogger(EducationService.class);

	@Autowired
	EducationRepository eRepo;
	
	public void addEducation(int jobSeekerId, String degree, String major, String instituteName, int yearOfPassing)
	{
		try
		{
			logger.info("received request to add education for job_seeker_id: {},",jobSeekerId);
			Education education = new Education();
			education.setJobSeekerId(jobSeekerId);
			education.setDegree(degree);
			education.setMajor(major);
			education.setInstituteName(instituteName);
			education.setYearOfPassing(yearOfPassing);
			eRepo.save(education);
			logger.info("Education added successfully for job_seeker_id: {}", jobSeekerId);
		}
		catch(Exception e)
		{
			logger.error("Error occurred while adding Education for job_seeker_id: {}",jobSeekerId , e);
            throw new RuntimeException("Failed to save Education. Please try again later.");
		}
	}

}
