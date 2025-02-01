package com.learning.jobsearchandhiring.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.jobsearchandhiring.model.Certifications;
import com.learning.jobsearchandhiring.repository.CertificationRepository;

@Service
public class CertificationService
{
	private static final Logger logger = LoggerFactory.getLogger(CertificationService.class);
	
	@Autowired
	CertificationRepository cRepo;

	public void addCertification(int jobSeekerId, String name, String issuer, Date issuedDate, Date validUntil) {
		try
		{
			logger.info("received request to add certification for job_seeker_id: {},",jobSeekerId);
			Certifications certification = new Certifications();
			certification.setJobSeekerId(jobSeekerId);
			certification.setName(name);
			certification.setIssuer(issuer);
			certification.setIssuedDate(issuedDate);
			certification.setValidUntil(validUntil);
			cRepo.save(certification);
			logger.info("Education added successfully for job_seeker_id: {}", jobSeekerId);
			
		}
		catch(Exception e)
		{
			logger.error("Error occurred while adding certification for job_seeker_id: {}",jobSeekerId , e);
            throw new RuntimeException("Failed to save Certification. Please try again later.");
		}
		
	}

}
