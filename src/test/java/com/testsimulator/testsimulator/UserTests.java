package com.testsimulator.testsimulator;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testsimulator.testsimulator.domain.User;
import com.testsimulator.testsimulator.domain.enums.TypeUser;
import com.testsimulator.testsimulator.repositories.UserRepository;


@SpringBootTest
public class UserTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testCreateUser () {
		User user1 = new User(null, "123.46.789-85", "lucas@email", "Lucas Coelho", TypeUser.ADMIN);
		
		userRepository.save(user1);
		
		assertNotNull(userRepository.findAll());
	}
}
