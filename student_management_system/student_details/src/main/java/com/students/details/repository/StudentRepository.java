package com.students.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.details.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
