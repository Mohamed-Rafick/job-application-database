package com.employmentApp.commonLib.dtos;

import com.employmentApp.commonLib.enums.WorkAuthorization;

public class ApplicationDto
{
	/*
	 * @author Mohamed Rafick
	 */
	
	private int jobId;
	private int jobSeekerId;
	private String experience;
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
