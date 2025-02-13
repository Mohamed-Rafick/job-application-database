package com.employmentApp.jobSeekerModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.jobSeekerModule.model.ApplicantSkills;


@Repository
public interface ApplicantSkillsRepository extends JpaRepository<ApplicantSkills, Integer>
{

}
