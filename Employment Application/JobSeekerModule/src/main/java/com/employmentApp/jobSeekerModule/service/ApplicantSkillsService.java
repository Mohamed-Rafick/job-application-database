package com.employmentApp.jobSeekerModule.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employmentApp.commonLib.dtos.ApplicantSkillsDto;
import com.employmentApp.commonLib.dtos.UserDto;
import com.employmentApp.jobSeekerModule.feignClients.UserFeignClient;
import com.employmentApp.jobSeekerModule.model.ApplicantSkills;
import com.employmentApp.jobSeekerModule.repository.ApplicantSkillsRepository;



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
	private UserFeignClient userClient;
	
	public ApplicantSkillsDto addSkills(int userId, ApplicantSkillsDto applicantSkillsDto)
	{
		UserDto user = userClient.getUser(userId);
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
			applicationSkills.setUserId(userId);
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
