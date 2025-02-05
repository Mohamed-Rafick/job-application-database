package com.employmentApp.service;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.employmentApp.dto.AddressDto;
import com.employmentApp.model.Address;
import com.employmentApp.model.User;
import com.employmentApp.repository.AddressRepository;
import com.employmentApp.repository.UserRepository;

@Service
public class AddressService 
{
	/*
	 * @author Mohamed Rafick
	 */
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private AddressRepository aRepo;

	public AddressDto addAddress(int userId, Address address)
	{
		logger.info("Attempting to add address for userId: {}", userId);
		User user = uRepo.findById(userId).orElse(null);
		if(user==null)
		{
			logger.error("User with ID {} not found", userId);
			throw new NoSuchElementException("User not found with ID"+ userId);
		}
		address.setUserId(userId);
		try
		{
			AddressDto addressDto = new AddressDto();
			Address savedAddress = aRepo.save(address);
			addressDto.setAddressLine1(savedAddress.getAddressLine1());
			addressDto.setAddressLine2(savedAddress.getAddressLine2());
			addressDto.setCity(savedAddress.getCity());
			addressDto.setState(savedAddress.getState());
			addressDto.setUserId(savedAddress.getUserId());
			addressDto.setZip(savedAddress.getZip());
			logger.info("Address saved successfully for userId: {}", userId);
			return addressDto;
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
