package com.learning.jobsearchandhiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jobsearchandhiring.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>
{

}
