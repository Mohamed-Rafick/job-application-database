package com.employmentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employmentApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
