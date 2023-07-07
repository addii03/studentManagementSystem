package one_to_one_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("one_to_one_book")
public class OneToOneMappingBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingBookApplication.class, args);
	}

}
