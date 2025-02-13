package com.employmentApp.userModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.userModule.model.Address;



@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> 
{

}
