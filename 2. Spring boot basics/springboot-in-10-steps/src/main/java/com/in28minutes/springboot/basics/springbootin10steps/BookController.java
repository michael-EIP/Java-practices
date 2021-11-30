package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@GetMapping("/books")
	public List<Book> GetBooks(){
		return Arrays.asList(
				new Book(1, "My new book", "Michale"), 
				new Book(2, "My data book 1", "Lucas"));
	}
}
