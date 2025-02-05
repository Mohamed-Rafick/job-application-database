package com.employmentApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employmentApp.dto.EducationDto;
import com.employmentApp.model.Education;
import com.employmentApp.model.User;
import com.employmentApp.repository.EducationRepository;
import com.employmentApp.repository.UserRepository;

@Service
public class EducationService
{
	/*
	 * @author Mohamed Rafick
	 */
	private static final Logger logger = LoggerFactory.getLogger(EducationService.class);

	@Autowired
	EducationRepository eRepo;
	
	@Autowired
	UserRepository uRepo;
	
	public EducationDto addEducation(int jobSeekerId, EducationDto educationDto)
	{
		User user=uRepo.findById(jobSeekerId).orElse(null);
		if(user==null)
		{
			logger.error("Job Seeker not found");
            throw new IllegalArgumentException("Job Seeker not found.");
		}
		try
		{
			logger.info("received request to add education for job_seeker_id: {},",jobSeekerId);
			Education education = new Education();
			education.setJobSeekerId(user.getUserId());
			education.setDegree(educationDto.getDegree());
			education.setMajor(educationDto.getMajor());
			education.setInstituteName(educationDto.getInstituteName());
			education.setYearOfPassing(educationDto.getYearOfPassing());
			eRepo.save(education);
			logger.info("Education added successfully for job_seeker_id: {}", jobSeekerId);
			return educationDto;
		}
		catch(Exception e)
		{
			logger.error("Error occurred while adding Education for job_seeker_id: {}",jobSeekerId , e);
            throw new RuntimeException("Failed to save Education. Please try again later.");
		}
	}

}
