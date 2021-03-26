package com.finalproject.user;

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
public class UserController {
	
	@Autowired
	UserRepository dao; 
	
	@GetMapping("/user")
	public List<User> getUsers() {
		List<User> foundUsers = dao.findAll();
		return foundUsers; 
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value="id") Integer id) {
		User foundUser = dao.findById(id).orElse(null); 
		
		if(foundUser == null) {
			return ResponseEntity.notFound().header("User", "User not found").build();
		}
		return ResponseEntity.ok(foundUser); 
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> postUser(@RequestBody User user) {
		User createdUser = dao.save(user); 
		
		return ResponseEntity.ok(createdUser); 
	}
	
	@PutMapping("/user/{id}") 
	public ResponseEntity<User> updateUser(@PathVariable(value="id") Integer id , @RequestBody User user) {
		User foundUser = dao.findById(id).orElse(null); 
		
		if(foundUser == null) {
			return ResponseEntity.notFound().header("User", "User not found").build(); 
		}
		else {
			foundUser = dao.save(user); 
		}
		return ResponseEntity.ok(foundUser); 
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="id") Integer id) {
		User foundUser = dao.findById(id).orElse(null); 
		
		if(foundUser == null) {
			return ResponseEntity.notFound().header("User", "User not found").build(); 
		}
		else {
			dao.delete(foundUser);
		}
		return ResponseEntity.ok().build(); 
	}

}
