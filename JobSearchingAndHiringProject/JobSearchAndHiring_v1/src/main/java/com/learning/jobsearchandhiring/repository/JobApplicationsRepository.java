package com.learning.jobsearchandhiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jobsearchandhiring.model.JobApplications;

@Repository
public interface JobApplicationsRepository extends JpaRepository<JobApplications,Integer>
{

}
