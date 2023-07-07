package springboot_one_to_one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot_one_to_one.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

}
