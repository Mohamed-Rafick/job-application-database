package com.employmentApp.dto;

import java.util.List;

public class ApplicantSkillsDto
{
	/*
	 * @author Mohamed Rafick
	 */
	private int applicationId;
	private int jobId;
	private List<String> skills;
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	
	
}
