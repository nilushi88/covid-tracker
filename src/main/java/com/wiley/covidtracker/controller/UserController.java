package com.wiley.covidtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.wiley.covidtracker.exception.ResourceNotFound;
import com.wiley.covidtracker.model.Patient;
import com.wiley.covidtracker.model.User;
import com.wiley.covidtracker.service.PatientService;
import com.wiley.covidtracker.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) throws ResourceNotFound {
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@PostMapping("/users")
	public User addPatient(@Validated @RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updatePatient(@Validated @RequestBody User user, @PathVariable long id) throws ResourceNotFound {
		return ResponseEntity.ok(userService.updateUser(user, id));
	}
}
