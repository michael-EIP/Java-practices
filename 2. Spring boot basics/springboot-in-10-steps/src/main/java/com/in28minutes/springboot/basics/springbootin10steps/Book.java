package com.in28minutes.springboot.basics.springbootin10steps;

public class Book {
	long id;
	String name;
	String author;
	
	public Book(long id, String name, String author) {
		super();
		this.id = id;
		this.author = author;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}
	
	
	
	
}
