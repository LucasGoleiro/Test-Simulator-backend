package com.testsimulator.testsimulator.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testsimulator.testsimulator.domain.User;
import com.testsimulator.testsimulator.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		User obj = userService.findOne(id);
		return ResponseEntity.ok().body(obj);
	}

}
