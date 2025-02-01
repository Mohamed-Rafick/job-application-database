package com.learning.jobsearchandhiring.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class JobApplications
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationId;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Jobs job;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private Users jobSeeker;
	
	@Lob
	private byte resume[];
	
	private String experience;
	
	@Enumerated(EnumType.STRING)
	private WorkAuthorization workAuthorization;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(nullable=false, updatable=false)
	private LocalDateTime appliedAt;
	
	@Column(nullable=false)
	private LocalDateTime updatedOn;
	
	@ManyToOne
	@JoinColumn(name="updated_by")
	private Users updatedBy;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	public Users getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(Users jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public WorkAuthorization getWorkAuthorization() {
		return workAuthorization;
	}

	public void setWorkAuthorization(WorkAuthorization workAuthorization) {
		this.workAuthorization = workAuthorization;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
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
	
	@PrePersist
	public void prePersist()
	{
		if(appliedAt==null)
		{
			this.appliedAt = LocalDateTime.now();
		}
		this.updatedOn =LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate()
	{
		this.updatedOn = LocalDateTime.now();
	}
}
