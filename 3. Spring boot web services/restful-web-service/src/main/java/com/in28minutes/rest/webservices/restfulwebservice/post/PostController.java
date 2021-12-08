package com.in28minutes.rest.webservices.restfulwebservice.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	private PostDAOService service;
	
	@GetMapping("/users/{userId}/posts")
	public List<Post> getAllPostsFromUser(@PathVariable int userId ){
		System.out.print("xxx");
		List<Post> posts = service.getAllPosts(userId);
		if (posts == null) {
			throw new PostExceptionNotFound("Posts not found for user-id: "+ userId);
		}
		return posts;
	}
	
	@PostMapping("/users/{userId}/posts")
	public ResponseEntity<Object> createAPost(@PathVariable int userId, @RequestBody Post post) {
		try {
			service.addPostFromUser(post);
		}
		catch (Exception ex) {
			throw new PostExceptionCreateFailed("Create post fail for user-id: "+ post.getUserId());
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
}
