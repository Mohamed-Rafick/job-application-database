package com.learning.jobsearchandhiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jobsearchandhiring.model.JobApplicationSkills;

@Repository
public interface JobApplicationSkillsRepository extends JpaRepository<JobApplicationSkills, Integer>
{

}
