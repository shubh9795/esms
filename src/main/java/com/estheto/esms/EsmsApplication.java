package com.estheto.esms;

import com.estheto.esms.models.Role;
import com.estheto.esms.models.User;
import com.estheto.esms.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class EsmsApplication {

//	@Bean
//	public CommandLineRunner setupDefaultUser(UserService service) {
//		return args -> {
//			service.save(new User(
//					"admin", //username
//					"admin", //password
//					Arrays.asList(Role.ADMIN),//roles
//					true//Active
//			));
//		};
//	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(EsmsApplication.class, args);
	}

}

