package com.employmentApp.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.employmentApp.enums.JobType;

public class JobDto {
	/*
	 * @author Mohamed Rafick
	 */
    private int jobId;
    private String position;
    private String company;
    private String experience;
    private List<String> skills;
    private String salary;
    private String location;
    private String education;
    private JobType jobType;
    private LocalDateTime createdOn;
    private LocalDateTime lastDate;
    private boolean hiringDone;
    private LocalDateTime updatedOn;
    private int updatedBy;
    private String description;
    
    // User-related fields
    private int userId;        
    private String username;    
    private String email;       
    
   
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDateTime lastDate) {
        this.lastDate = lastDate;
    }

    public boolean isHiringDone() {
        return hiringDone;
    }

    public void setHiringDone(boolean hiringDone) {
        this.hiringDone = hiringDone;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // User-related fields Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    // Optional: You can add a method to populate the User and UpdatedBy details (if needed)
    public void setUserDetails(int userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }
    
    public void setUpdatedByDetails(int updatedBy) {
        this.updatedBy = updatedBy;
    }
}
