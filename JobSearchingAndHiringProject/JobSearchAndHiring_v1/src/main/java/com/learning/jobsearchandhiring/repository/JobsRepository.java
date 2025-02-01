package com.learning.jobsearchandhiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jobsearchandhiring.model.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer>
{

}
