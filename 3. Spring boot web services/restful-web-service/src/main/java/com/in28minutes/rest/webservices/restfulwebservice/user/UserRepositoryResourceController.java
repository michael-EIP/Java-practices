package com.in28minutes.rest.webservices.restfulwebservice.user;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@RestController
public class UserRepositoryResourceController {
	
	@Autowired
	private UserRepositoryJPA userRepository;
	
	@GetMapping(path="/jpa/users")
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public User findUserById(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		throw new UserNotFoundException("User not found id: "+id);
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		User createdUser = userRepository.save(user);
		Object x = new Object() { public int id = createdUser.getId();};
		
		return new ResponseEntity(x,HttpStatus.CREATED);
	}
}
