package com.finalproject.post;

import java.time.LocalDateTime;
import javax.persistence.*; 


@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id; 
	private String authorID; 
	private String message; 
	LocalDateTime now = LocalDateTime.now(); 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getLocalDateTime() {
		return now;
	}
	
}
