package com.in28minutes.rest.webservices.restfulwebservice.post;

import java.util.Date;

public class Post {
	private Integer Id;
	private String Content;
	private Date publishedDate;
	private Integer UserId;
	
	public Post(Integer id, String content, Date publishedDate, Integer userId) {
		super();
		this.Id = id;
		this.Content = content;
		this.publishedDate = publishedDate;
		this.UserId = userId;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}
	
	
	
}
