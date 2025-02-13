package com.employmentApp.jobSeekerModule.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employmentApp.commonLib.dtos.EducationDto;
import com.employmentApp.commonLib.dtos.UserDto;
import com.employmentApp.jobSeekerModule.feignClients.UserFeignClient;
import com.employmentApp.jobSeekerModule.model.Education;
import com.employmentApp.jobSeekerModule.repository.EducationRepository;


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
	private UserFeignClient userClient;
	
	public EducationDto addEducation(int jobSeekerId, EducationDto educationDto)
	{
		UserDto user=userClient.getUser(jobSeekerId);
		if(user==null)
		{
			logger.error("Job Seeker not found");
            throw new IllegalArgumentException("Job Seeker not found.");
		}
		try
		{
			logger.info("received request to add education for job_seeker_id: {},",jobSeekerId);
			Education education = new Education();
			education.setJobSeekerId(jobSeekerId);
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
