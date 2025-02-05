package com.employmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>
{

}
