package com.testsimulator.testsimulator.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.testsimulator.testsimulator.domain.User;
import com.testsimulator.testsimulator.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		User user = userService.findOne(id);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody User user) {
		user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}

}
