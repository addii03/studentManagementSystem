package com.SpringBoot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.backend.model.Employee;

@Repository
public interface employee_Repository extends JpaRepository<Employee, Integer> {

}
