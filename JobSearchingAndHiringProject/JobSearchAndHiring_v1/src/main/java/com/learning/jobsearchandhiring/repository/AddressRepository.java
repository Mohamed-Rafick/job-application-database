package com.learning.jobsearchandhiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.jobsearchandhiring.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> 
{

}
