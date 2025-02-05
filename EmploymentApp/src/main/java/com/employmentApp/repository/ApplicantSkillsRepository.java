package com.employmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.model.ApplicantSkills;

@Repository
public interface ApplicantSkillsRepository extends JpaRepository<ApplicantSkills, Integer>
{

}
