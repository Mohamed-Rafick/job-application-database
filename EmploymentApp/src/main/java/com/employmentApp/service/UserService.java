package com.employmentApp.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employmentApp.dto.UserDto;
import com.employmentApp.enums.Role;
import com.employmentApp.model.User;
import com.employmentApp.repository.UserRepository;

@Service
public class UserService
{
	/*
	 * @author Mohamed Rafick
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
 
	public UserDto addUser(User user)
	{
		logger.info("Attempting to add user: {}", user.getUserName());
		UserDto userDto = new UserDto();  
		userDto.setUserName(user.getUserName());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());  
        userDto.setRole(user.getRole()); 
		    
        if (user.getPassword() != null && !user.getPassword().isEmpty())
		{
		    String hashedPassword = encoder.encode(user.getPassword());
		    user.setPassword(hashedPassword);
		}
		    
		
		try
		{
			repo.save(user);
			logger.info("User saved successfully: {}", user.getUserName());
			return userDto;
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
		 User user = repo.findById(userId).orElse(null);

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
		User user = repo.findById(userId).orElse(null);
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
