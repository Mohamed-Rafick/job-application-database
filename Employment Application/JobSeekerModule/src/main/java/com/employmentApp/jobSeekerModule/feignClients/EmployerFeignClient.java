package com.employmentApp.jobSeekerModule.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employmentApp.commonLib.dtos.JobDto;


@FeignClient(name = "EmployerModule")
public interface EmployerFeignClient
{
	@GetMapping("job/get/{jobId}")
	JobDto getJob(@PathVariable int jobId);
}
