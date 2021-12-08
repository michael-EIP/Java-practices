package com.in28minutes.rest.webservices.restfulwebservice.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDAOService {
	static private List<Post> listPosts = new ArrayList<Post>();
	
	static {
		listPosts.add(new Post(1, "abc", new Date(), 1));
	}
	
	
	public void addPostFromUser(Post post) {
		listPosts.add(post);
	}
	
	public List<Post> getAllPosts(int userID){
		List<Post> results = new ArrayList<Post>();
		
		if(userID == 0) {
			return null;
		} else {
			for(Post post : listPosts) {
				if (post.getUserId() == userID) {
					results.add(post);
				}
			}
		}
		return results;
	}
	
	public Post getPostFromUser(int userId, int postId) {
		for (Post post: listPosts) {
			if (post.getId() == postId&& post.getUserId()== userId)
				return post;
		}
		
		return null;
	}

	
}
