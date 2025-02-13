package com.employmentApp.jobSeekerModule.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name="certifications")
public class Certification
{
	/*
	 * @author Mohamed Rafick
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int certificationId;
	
	@NotNull(message = "Job seeker ID cannot be null")
	@Column(name="job_seeker_id", nullable=false)
	private int jobSeekerId;
	
	@NotNull(message = "Certification name cannot be null")
	@Column(name="name", nullable=false)
	private String name;
	
	@NotNull(message = "Issuer cannot be null")
	@Column(name="issuer", nullable=false)
	private String issuer;
	
	@NotNull(message = "Issued date cannot be null")
    @PastOrPresent(message = "Issued date must be in the past or present")
	@Column(name="issued_date", nullable=false)
	private LocalDateTime issuedDate;
	
	@NotNull(message = "Issued date cannot be null")
    @PastOrPresent(message = "Issued date must be in the past or present")
	@Column(name="valid_until")
	private LocalDateTime validUntil;

	
	
	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public LocalDateTime getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDateTime issuedDate) {
		this.issuedDate = issuedDate;
	}

	public LocalDateTime getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(LocalDateTime validUntil) {
		this.validUntil = validUntil;
	}
	
	
}
