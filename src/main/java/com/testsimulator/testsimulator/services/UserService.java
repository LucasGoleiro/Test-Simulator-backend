package com.testsimulator.testsimulator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testsimulator.testsimulator.domain.User;
import com.testsimulator.testsimulator.repositories.UserRepository;
import com.testsimulator.testsimulator.services.exceptions.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findOne(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"User not found with ID: " + id));
	}
	
	public User insert(User user) {
		user.setId(null);
		return userRepository.save(user);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
