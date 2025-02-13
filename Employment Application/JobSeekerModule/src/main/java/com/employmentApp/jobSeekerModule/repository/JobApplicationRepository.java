package com.employmentApp.jobSeekerModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.jobSeekerModule.model.JobApplication;


@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Integer>
{

}
