package com.employmentApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="educations")
public class Education
{
	/*
	 * @author Mohamed Rafick
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="education_id")
	private int educationId;
	
	@NotNull(message = "Job seeker ID cannot be null")
	@Column(name="job_seeker_id", nullable=false)
	private int jobSeekerId;
	
	@NotEmpty(message = "Degree cannot be empty")
	@Column(name="degree", nullable=false)
	private String degree;
	
	@Column(name="major")
	private String major;
	
	@NotEmpty(message = "Institute name cannot be empty")
	@Column(name="institute_name", nullable=false)
	private String instituteName;
	
	@NotNull(message = "Year of passing cannot be null")
	@Column(name="year_of_passing", nullable=false)
	private int yearOfPassing;

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public int getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	
	
	
}
