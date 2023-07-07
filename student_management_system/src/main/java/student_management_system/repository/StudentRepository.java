package student_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import student_management_system.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	//List<Student> findByStudentIdIn(List<Integer> ids);
	
    @Query("select s from Student s where s.studentDeleted= :studentDeleted")
    List<Student> findAllByDeletedFalse(boolean studentDeleted);
    
}
