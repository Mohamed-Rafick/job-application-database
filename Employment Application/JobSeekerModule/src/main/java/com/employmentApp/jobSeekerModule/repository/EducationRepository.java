package com.employmentApp.jobSeekerModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.jobSeekerModule.model.Education;


@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>
{

}
