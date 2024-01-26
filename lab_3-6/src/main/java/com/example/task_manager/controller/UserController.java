package com.example.task_manager.controller;


import com.example.task_manager.model.User;
import com.example.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}

	@PostMapping("create_user")
	public String createUser(@RequestBody User user){
		return service.createUser(user);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id){
		return service.getUser(id);
	}

	@PutMapping("update_user")
	public String updateUser(@RequestBody User user){
		return service.updateUser(user);
	}

	@DeleteMapping("delete_user/{id}")
	public String deleteUser(@PathVariable Long id){
		return service.deleteUser(id);
	}



}
