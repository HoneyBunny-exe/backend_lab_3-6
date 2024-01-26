package com.example.task_manager.service;

import com.example.task_manager.model.User;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();

	String createUser(User user);

	User getUser(Long id);

	String updateUser(User user);

 	String deleteUser(Long id);
}
