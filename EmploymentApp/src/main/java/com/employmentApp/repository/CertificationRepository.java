package com.employmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.model.Certification;


@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer>
{

}
