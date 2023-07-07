package student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student_management_system.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
