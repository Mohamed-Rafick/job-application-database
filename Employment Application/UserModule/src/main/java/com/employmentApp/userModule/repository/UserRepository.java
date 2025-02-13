package com.employmentApp.userModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.userModule.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
