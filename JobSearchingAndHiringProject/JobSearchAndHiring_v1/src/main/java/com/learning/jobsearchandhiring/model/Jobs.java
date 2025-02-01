package com.learning.jobsearchandhiring.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import jakarta.persistence.Transient;


@Entity
public class Jobs
{
	
	
	public Jobs()
	{
		
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable=false)
	private Users user;
	
	@Column(nullable=false)
	private String position;
	
	@Column(nullable=false)
	private String company;
	
	private String experience;
	
	@Transient
	private List<String> skills;
	
	@Column(nullable = false, columnDefinition = "json")
    private String skillsJson;
	
	private String salary;
	
	private String location;
	
	private String education;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private JobType jobType;
	
	@Column(nullable=false, updatable=false)
	private LocalDateTime createdOn;
	
	@Column(nullable=false)
	private Date lastDate;
	
	private boolean hiringDone;
	
	@Column(nullable=false)
	private LocalDateTime updatedOn;
	
	@ManyToOne
	@JoinColumn(name = "updated_by")
	private Users updatedBy;
	
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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
            if (this.skillsJson != null && !this.skillsJson.isEmpty()) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(this.skillsJson, List.class);  // Deserialize JSON to List<String>
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
                this.skillsJson = objectMapper.writeValueAsString(skills);  // Serialize List<String> to JSON
            } else {
                this.skillsJson = "[]";  // Store an empty list in JSON format
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

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
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

	public Users getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Users updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}

