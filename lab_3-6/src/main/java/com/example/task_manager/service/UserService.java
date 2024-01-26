package com.example.task_manager.service;

import com.example.task_manager.dto.UserDTO;
import com.example.task_manager.model.User;

import java.util.List;

public interface UserService {
	List<UserDTO> getAllUsers();

	String createUser(UserDTO user);

	UserDTO getUser(Long id);

	String updateUser(UserDTO user);

 	String deleteUser(Long id);
}
