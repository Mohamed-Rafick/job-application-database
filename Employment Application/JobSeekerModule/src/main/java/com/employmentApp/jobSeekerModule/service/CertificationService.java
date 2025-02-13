package com.employmentApp.jobSeekerModule.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employmentApp.commonLib.dtos.CertificationDto;
import com.employmentApp.commonLib.dtos.UserDto;
import com.employmentApp.jobSeekerModule.feignClients.UserFeignClient;
import com.employmentApp.jobSeekerModule.model.Certification;
import com.employmentApp.jobSeekerModule.repository.CertificationRepository;


@Service
public class CertificationService
{
	/*
	 * @author Mohamed Rafick
	 */
	private static final Logger logger = LoggerFactory.getLogger(CertificationService.class);
	
	@Autowired
	CertificationRepository cRepo;
	
	@Autowired
	private UserFeignClient userClient;

	public CertificationDto addCertification(int jobSeekerId, CertificationDto certificationDto)
	{
		UserDto user=userClient.getUser(jobSeekerId);
		if(user==null)
		{
			logger.error("Job Seeker not found");
            throw new IllegalArgumentException("Job Seeker not found.");
		}
		try
		{
			logger.info("received request to add certification for job_seeker_id: {},",jobSeekerId);
			Certification certification = new Certification();
			certification.setJobSeekerId(jobSeekerId);
			certification.setName(certificationDto.getName());
			certification.setIssuer(certificationDto.getIssuer());
			certification.setIssuedDate(certificationDto.getIssuedDate());
			certification.setValidUntil(certificationDto.getValidUntil());
			cRepo.save(certification);
			logger.info("Education added successfully for job_seeker_id: {}", jobSeekerId);
			return certificationDto;
		}
		catch(Exception e)
		{
			logger.error("Error occurred while adding certification for job_seeker_id: {}",jobSeekerId , e);
            throw new RuntimeException("Failed to save Certification. Please try again later.");
		}
		
	}

}
