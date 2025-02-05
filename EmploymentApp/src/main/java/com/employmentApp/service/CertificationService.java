package com.employmentApp.service;

import java.time.LocalDateTime;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employmentApp.dto.CertificationDto;
import com.employmentApp.model.Certification;
import com.employmentApp.model.User;
import com.employmentApp.repository.CertificationRepository;
import com.employmentApp.repository.UserRepository;

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
	UserRepository uRepo;

	public CertificationDto addCertification(int jobSeekerId, CertificationDto certificationDto)
	{
		User user=uRepo.findById(jobSeekerId).orElse(null);
		if(user==null)
		{
			logger.error("Job Seeker not found");
            throw new IllegalArgumentException("Job Seeker not found.");
		}
		try
		{
			logger.info("received request to add certification for job_seeker_id: {},",jobSeekerId);
			Certification certification = new Certification();
			certification.setJobSeekerId(user.getUserId());
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
