package com.in28minutes.rest.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceController {
	
	@Autowired
	private UserDAOService service;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return service.getAll(); 
	}
	
	@GetMapping(path="/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user==null) {	
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	public void DeleteUser(int userId) {
		User user = service.deleteUser(userId);
		if (user==null) {	
			throw new UserNotFoundException("id-"+userId);
		}
	}
}
