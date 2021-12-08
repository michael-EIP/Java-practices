package com.in28minutes.rest.webservices.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	private static List<User> users = new ArrayList<>();
	
	private static int count = 3;
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Alex", new Date()));
		users.add(new User(3, "Evan", new Date()));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user:users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUser(int id) {
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id)
				itr.remove();
				return user;
		}
		return null; 
	}
	
}
