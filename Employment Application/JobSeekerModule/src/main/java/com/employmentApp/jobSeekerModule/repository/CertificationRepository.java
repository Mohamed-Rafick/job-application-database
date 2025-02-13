package com.employmentApp.jobSeekerModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.jobSeekerModule.model.Certification;



@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer>
{

}
