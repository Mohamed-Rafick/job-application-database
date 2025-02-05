package com.employmentApp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employmentApp.dto.ApplicantSkillsDto;
import com.employmentApp.model.ApplicantSkills;
import com.employmentApp.model.User;
import com.employmentApp.repository.ApplicantSkillsRepository;
import com.employmentApp.repository.UserRepository;


@Service
public class ApplicantSkillsService
{
	/*
	 * @author Mohamed Rafick
	 */
	 private static final Logger logger = LoggerFactory.getLogger(ApplicantSkillsService.class);
	
	@Autowired
	ApplicantSkillsRepository jASRepo;
	
	@Autowired
	UserRepository uRepo;;
	
	public ApplicantSkillsDto addSkills(int userId, ApplicantSkillsDto applicantSkillsDto)
	{
		User user = uRepo.findById(userId).orElse(null);
		if(user==null)
		{
			logger.error("user not found");
            throw new IllegalArgumentException("user not found.");
		}
		try 
		{
			
			logger.info("Received request to add skills for applicationId: {}, userId: {}, jobId: {}", applicantSkillsDto.getApplicationId(), userId, applicantSkillsDto.getJobId());
			ApplicantSkills applicationSkills = new ApplicantSkills();
			applicationSkills.setApplicationId(applicantSkillsDto.getApplicationId());
			applicationSkills.setUserId(user.getUserId());
			applicationSkills.setJobId(applicantSkillsDto.getJobId());
			applicationSkills.setJsonSkills(applicantSkillsDto.getSkills());
			jASRepo.save(applicationSkills);
			logger.info("Skills added successfully for applicationId: {}", applicantSkillsDto.getApplicationId());
			return applicantSkillsDto;
		}
		catch(Exception e)
		{
			logger.error("Error occurred while adding skills for applicationId: {}", applicantSkillsDto.getApplicationId(), e);
            throw new RuntimeException("Failed to save skills. Please try again later.");
		}
	
	}
}
