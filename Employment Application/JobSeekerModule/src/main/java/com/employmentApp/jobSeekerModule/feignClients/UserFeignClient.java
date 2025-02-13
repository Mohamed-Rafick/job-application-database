package com.employmentApp.jobSeekerModule.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employmentApp.commonLib.dtos.UserDto;

@FeignClient(name = "UserModule")
public interface UserFeignClient
{
	@GetMapping("user/get/{userId}")
	UserDto getUser(@PathVariable int userId);
}
