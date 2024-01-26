package com.example.task_manager.controller;


import com.example.task_manager.dto.UserDTO;
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
	public List<UserDTO> getAllUsers(){
		return service.getAllUsers();
	}

	@PostMapping("create_user")
	public String createUser(@RequestBody UserDTO dto){
		return service.createUser(dto);
	}

	@GetMapping("/{id}")
	public UserDTO getUser(@PathVariable Long id){
		return service.getUser(id);
	}

	@PutMapping("update_user")
	public String updateUser(@RequestBody UserDTO dto){
		return service.updateUser(dto);
	}

	@DeleteMapping("delete_user/{id}")
	public String deleteUser(@PathVariable Long id){
		return service.deleteUser(id);
	}



}
