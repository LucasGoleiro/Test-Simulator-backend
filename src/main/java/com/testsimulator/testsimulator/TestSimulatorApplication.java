package com.testsimulator.testsimulator;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.testsimulator.testsimulator.domain.User;
import com.testsimulator.testsimulator.domain.enums.TypeUser;
import com.testsimulator.testsimulator.repositories.UserRepository;

@SpringBootApplication
public class TestSimulatorApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestSimulatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "123.46.789-85", "lucas@email", "Lucas Coelho", TypeUser.ADMIN);
		User user2 = new User(null, "123.46.789-85", "joao@email", "Joao Coelho", TypeUser.FREE_USER);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
	}

}
