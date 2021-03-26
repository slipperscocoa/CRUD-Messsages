package com.finalproject.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List; 

@RestController
public class PostController {
	
	@Autowired
	PostRepository dao; 
	
	@GetMapping("user/{id}/post")
	public List<Post> getPosts() {
		List<Post> foundPosts = dao.findAll(); 
		return foundPosts; 
	}
	
	@GetMapping("user/{id}/post/{id}") 
	public ResponseEntity<Post> getPost(@PathVariable(value="id") Integer id) {
		Post foundPost = dao.findById(id).orElse(null); 
		
		if (foundPost == null) {
			return ResponseEntity.notFound().header("Post", "Post not found").build(); 
		}
		return ResponseEntity.ok(foundPost); 
	}
	
	@PostMapping("user/{id}/post")
	public ResponseEntity<Post> postPost(@RequestBody Post post) {
		Post createdPost = dao.save(post); 
		
		return ResponseEntity.ok(createdPost); 
	}
	
	@PutMapping("user/{id}/post/{id}") 
	public ResponseEntity<Post> updatePost(@PathVariable(value="id") Integer id , @RequestBody Post post) {
		Post foundPost = dao.findById(id).orElse(null); 
		
		if(foundPost == null) {
			return ResponseEntity.notFound().header("Post", "Post not found").build(); 
		}
		else {
			foundPost = dao.save(post); 
		}
		return ResponseEntity.ok(foundPost); 
	}
	
	@DeleteMapping("user/{id}/post/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable(value="id") Integer id) {
		Post foundPost = dao.findById(id).orElse(null); 
		
		if (foundPost == null) {
			return ResponseEntity.notFound().header("Post", "Post not found").build(); 
		}
		else {
			dao.delete(foundPost); 
		}
		return ResponseEntity.ok().build(); 
	}
}
