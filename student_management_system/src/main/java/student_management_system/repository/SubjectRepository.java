package student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student_management_system.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
