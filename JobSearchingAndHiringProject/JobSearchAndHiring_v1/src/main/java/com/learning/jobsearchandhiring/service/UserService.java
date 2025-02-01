package com.learning.jobsearchandhiring.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.learning.jobsearchandhiring.model.Role;
import com.learning.jobsearchandhiring.model.Users;
import com.learning.jobsearchandhiring.repository.UserRepository;

@Service
public class UserService
{
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository repo;
	
	public Users addUser(Users user)
	{
		logger.info("Attempting to add user: {}", user.getUserName());

		if(user.getUserName()==null || user.getUserName().isEmpty())
		{
			logger.error("User name cannot be empty.");
			throw new IllegalArgumentException("User name cannot be empty");
		}
		if(user.getFirstName()==null || user.getFirstName().isEmpty())
		{
			logger.error("First Name cannot be empty.");
			throw new IllegalArgumentException("First Name cannot be empty");
		}
		if(user.getLastName()==null || user.getLastName().isEmpty())
		{
			logger.error("Last Name cannot be empty.");
			throw new IllegalArgumentException("Last Name can not be empty");
		}
		if(user.getEmail()==null || user.getEmail().isEmpty())
		{
			logger.error("Email cannot be empty.");
			throw new IllegalArgumentException("Email cannot be empty");
		}
		if(user.getPassword()==null || user.getPassword().isEmpty())
		{
			logger.error("Password cannot be empty.");
			throw new IllegalArgumentException("Password cannot be empty");
		}
		if(user.getPhoneNumber()==null || user.getPhoneNumber().isEmpty())
		{
			logger.error("Phone Number cannot be empty.");
			throw new IllegalArgumentException("Phone Number cannot be empty");
		}
		
		try
		{
			Users savedUser = repo.save(user);
			logger.info("User saved successfully: {}", savedUser.getUserName());
			return savedUser;
		}
		catch(DataIntegrityViolationException e)
		{
			if(e.getMessage().contains("userName"))
			{
				logger.error("User with this username already exists.");
				throw new RuntimeException("User with this username already exists.");
			}
			else if(e.getMessage().contains("email"))
			{
				logger.error("User with this email already exists.");
				throw new RuntimeException("User with this email already exists.");
			}
			else if (e.getMessage().contains("phoneNumber"))
			{
				logger.error("User with this phone number already exists.");
		        throw new RuntimeException("User with this phone number already exists.");
		    }
		    else
		    {
		    	logger.error("A data integrity violation occurred.");
		        throw new RuntimeException("A data integrity violation occurred.");
		    }
		}
		catch (Exception e)
		{
			logger.error("An error occurred while adding the user: {}", e.getMessage(), e);
            throw new RuntimeException("An error occurred while adding the user.");
        }
	}

	
	public boolean updateSsn(int userId, String ssn)
	 {
		 Users user = repo.findById(userId).orElse(null);

		  if (user == null)
		  {
	            logger.error("User with ID {} not found.", userId);
	            return false;
	      }

	      try 
	      {
	          user.setSsn(ssn);
	          repo.save(user);
	          logger.info("SSN updated successfully for user: {}", user.getUserName());
	          return true;
	      }
	      catch (DataIntegrityViolationException e) 
	      {
	          logger.error("Data integrity violation occurred while updating SSN: {}", e.getMessage());
	          return false;
	      } 
	      catch (Exception e)
	      {
	          logger.error("An error occurred while updating SSN for user: {}", e.getMessage());
	          return false;
	      }
	  }


	public boolean updateRole(int userId, Role role)
	{
		Users user = repo.findById(userId).orElse(null);
		if(user==null)
		{
			logger.error("User with ID {} not found.", userId);
			return false;
		}
		try
		{
			user.setRole(role);
			repo.save(user);
			logger.info("Role updated successfully for user: {}", user.getUserName());
			return true;
		}
		catch(DataIntegrityViolationException e)
		{
			logger.error("Data integrity violation occurred while updating Role: {}", e.getMessage());
			return false;
		}
		catch(Exception e)
		{
			logger.error("An error occurred while updating Role for user {}: {}", userId, e.getMessage());
			return false;
		}
	}
	
}
