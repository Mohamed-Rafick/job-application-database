package com.learning.jobsearchandhiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jobsearchandhiring.model.Certifications;


@Repository
public interface CertificationRepository extends JpaRepository<Certifications, Integer>
{

}
