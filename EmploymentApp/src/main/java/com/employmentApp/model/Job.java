package com.employmentApp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.employmentApp.enums.JobType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="jobs")
public class Job
{
	/*
	 * @author Mohamed Rafick
	 */
	
	public Job()
	{
		
	}
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobId;

	@NotNull(message = "User ID cannot be null")
    @Column(name = "user_id", nullable = false)
    private int userId; 
 
    @NotBlank(message = "Position cannot be empty.")
    @Column(name = "position", nullable = false)
    private String position;

    @NotBlank(message = "Company cannot be empty.")
    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "experience")
    private String experience;

    //@Transient
    //@Column(name = "skills")
    //private List<String> skillsJson;

    @NotNull(message = "Skills cannot be null")
    @Column(nullable = false, columnDefinition = "json")
    private String skills;

    @NotNull(message = "Salary cannot be null")
    @Column(name = "salary")
    private String salary;
    
    @NotNull(message = "Location cannot be null")
    @Column(name = "location")
    private String location;

    @NotNull(message = "Education cannot be null")
    @Column(name = "education")
    private String education;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Job type cannot be empty.")
    @Column(name = "job_type", nullable = false)
    private JobType jobType;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "last_date", nullable = false)
    @NotNull(message = "Last date cannot be empty.")
    private LocalDateTime lastDate;

    @Column(name = "hiring_done")
    private boolean hiringDone;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;
    
    @Column(name = "updated_by")
    private Integer updatedBy;

    @NotNull(message = "Description cannot be null")
    @Column(name = "description")
    private String description;


	
	@PrePersist
	public void prePersist()
	{
		if(this.createdOn==null)
		{
			this.createdOn=LocalDateTime.now();
		}
		this.updatedOn=LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate()
	{
		this.updatedOn=LocalDateTime.now();
	}
	
	
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		try {
            if (this.skills != null && !this.skills.isEmpty()) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(this.skills, List.class);  // Deserialize JSON to List<String>
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();  // Handle errors if necessary
        }
        return new ArrayList<>();
	}

	public void setSkills(List<String> skills) {
		try {
            if (skills != null && !skills.isEmpty()) {
                ObjectMapper objectMapper = new ObjectMapper();
                this.skills = objectMapper.writeValueAsString(skills);  // Serialize List<String> to JSON
            } else {
                this.skills = "[]";  // Store an empty list in JSON format
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();  // Handle errors if necessary
        }
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

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}

