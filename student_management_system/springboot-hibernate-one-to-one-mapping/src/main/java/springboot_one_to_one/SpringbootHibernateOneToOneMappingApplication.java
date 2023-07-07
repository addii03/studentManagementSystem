package springboot_one_to_one;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springboot_one_to_one.entity.Gender;
import springboot_one_to_one.entity.User;
import springboot_one_to_one.entity.UserProfile;
import springboot_one_to_one.repository.UserProfieRepository;
import springboot_one_to_one.repository.UserRepository;

@SpringBootApplication
public class SpringbootHibernateOneToOneMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneToOneMappingApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfieRepository userProfieRepository;

	@Override
	public void run(String... args) throws Exception {
		// create user object

		User user = new User();
		user.setId(10);
		user.setName("aditya");
		user.setEmail("aditya@gmail.com");

		UserProfile userProfile = new UserProfile();
		userProfile.setId(100);
		userProfile.setPhoneNumber("9898989898");
		userProfile.setGender(Gender.MALE);
		userProfile.setBirthOfDate(LocalDate.of(2023, 05, 24));
		userProfile.setAddress("thane");

		user.setUserProfile(userProfile);
		userProfile.setUser(user);

		userRepository.save(user);
	}

}
