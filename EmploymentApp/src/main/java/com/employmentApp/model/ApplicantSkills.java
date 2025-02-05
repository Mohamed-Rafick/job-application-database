package com.employmentApp.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="applicant_skills")
public class ApplicantSkills {

	/*
	 * @author Mohamed Rafick
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="applicant_skills_id")
    private int applicantSkillsId;

    @NotNull(message = "Application ID cannot be null")
    @Column(name="application_id", nullable=false)
    private int applicationId;
    
    @NotNull(message = "User ID cannot be null")
    @Column(name="user_id", nullable=false)
    private int userId;
    
    @NotNull(message = "Job ID cannot be null")
    @Column(name="job_id", nullable=false)
    private int jobId;

    @Transient
	private List<String> jsonSkills;
    
    @Lob
    @Column(name="skills")
    @NotNull(message = "Skills cannot be null")
    private String skills;

    public int getApplicantSkillsId() {
        return applicantSkillsId;
    }

    public void setApplicantSkillsId(int applicantSkillsId) {
        this.applicantSkillsId = applicantSkillsId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public List<String> getJsonSkills()
    {
        // Deserialize the JSON string from the `skills` field into a List<String>
        try 
        {
            if (this.skills != null && !this.skills.isEmpty())
            {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(this.skills, List.class);  // Deserialize JSON to List<String>
            }
        } 
        catch (JsonProcessingException e)
        {
            e.printStackTrace();  
        }
        return new ArrayList<>();  // Return an empty list if no skills are found
    }

    public void setJsonSkills(List<String> jsonSkills)
    {
        // Serialize the List<String> into a JSON string and store it in `skills`
        try 
        {
            if (jsonSkills != null && !jsonSkills.isEmpty()) 
            {
                ObjectMapper objectMapper = new ObjectMapper();
                this.skills = objectMapper.writeValueAsString(jsonSkills);  // Serialize List<String> to JSON
            } 
            else 
            {
                this.skills = "[]";  // Store an empty list in JSON format
            }
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();  // Handle errors if necessary
        }
    }

    public String getSkills() {
        return skills;  // Return the JSON string stored in the database
    }

    public void setSkills(String skills) {
        this.skills = skills;  // Set the raw JSON string (from the database)
    }

}