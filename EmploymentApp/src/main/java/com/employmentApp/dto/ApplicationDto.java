package com.employmentApp.dto;

import com.employmentApp.enums.WorkAuthorization;

import jakarta.validation.constraints.NotNull;

public class ApplicationDto
{
	/*
	 * @author Mohamed Rafick
	 */
	@NotNull(message = "Job ID cannot be null")
	private int jobId;
	
	@NotNull(message = "Job Seeker ID cannot be null")
	private int jobSeekerId;
	
	
	private String experience;
	
	@NotNull(message = "Work Authorization is required")
	private WorkAuthorization workAuth;
	
	
	public int getJobId() { 
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getJobSeekerId() {
		return jobSeekerId;
	}
	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public WorkAuthorization getWorkAuth() {
		return workAuth;
	}
	public void setWorkAuth(WorkAuthorization workAuth) {
		this.workAuth = workAuth;
	}
	
	
}
