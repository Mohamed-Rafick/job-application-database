package com.learning.jobsearchandhiring.service;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.learning.jobsearchandhiring.model.Address;
import com.learning.jobsearchandhiring.model.Users;
import com.learning.jobsearchandhiring.repository.AddressRepository;
import com.learning.jobsearchandhiring.repository.UserRepository;

@Service
public class AddressService 
{
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private AddressRepository aRepo;

	public boolean addAddress(int userId, Address address)
	{
		logger.info("Attempting to add address for userId: {}", userId);
		Users user = uRepo.findById(userId).orElse(null);
		if(user==null)
		{
			logger.error("User with ID {} not found", userId);
			throw new NoSuchElementException("User not found with ID"+ userId);
		}
		address.setUser(user);
		try
		{
			aRepo.save(address);
			logger.info("Address saved successfully for userId: {}", userId);
			return true;
		}
		catch(DataIntegrityViolationException e)
		{
			if(e.getMessage().contains("address"))
			{
				logger.error("Address data integrity violation occured for userId: {}", userId);
				throw new RuntimeException("Address data integrity violation.");
			}
			else
			{
				logger.error("Data integrity violation occurred while adding address for userId: {}", userId, e);
				throw new RuntimeException("A data integrity violation occurred.");
			}
		}
		catch(Exception e)
		{
			logger.error("An error occurred while adding address for userId: {}", userId, e);
	        throw new RuntimeException("An error occurred while adding the address.");
	    }
	
	}

}
