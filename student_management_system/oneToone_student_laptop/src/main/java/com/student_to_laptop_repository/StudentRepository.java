package com.student_to_laptop_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_to_laptop.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
