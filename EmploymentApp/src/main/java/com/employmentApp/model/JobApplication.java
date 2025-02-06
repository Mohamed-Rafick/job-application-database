package com.employmentApp.model;

import java.time.LocalDateTime;

import com.employmentApp.enums.Status;
import com.employmentApp.enums.WorkAuthorization;

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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="job_applications")
public class JobApplication
{
	/*
	 * @author Mohamed Rafick
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="application_id")
	private int applicationId;
	
	
	@NotNull(message = "Job ID cannot be null")
	@Column(name="job_id")
	private int jobId;
	
	@NotNull(message = "Job Seeker ID cannot be null")
	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	//@Lob
	@NotNull(message = "Resume cannot be null")
	@Column(name="resume", columnDefinition = "LONGBLOB")
	private byte resume[];
	
	@Column(name="experience")
	private String experience;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Work Authorization cannot be null")
	@Column(name="work_authorization")
	private WorkAuthorization workAuthorization;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Status cannot be null")
	@Column(name="status")
	private Status status;
	
	@Column(name="applied_at", nullable=false, updatable=false)
	private LocalDateTime appliedAt;
	
	@Column(name="updated_on", nullable=false)
	private LocalDateTime updatedOn;

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

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
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
