package com.in28minutes.rest.webservices.restfulwebservice.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String content;
	
	private Date publishedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", publishedDate=" + publishedDate + ", user=" + user + "]";
	}
	
	
}
