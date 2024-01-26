package com.example.task_manager.service.impl;

import com.example.task_manager.model.User;
import com.example.task_manager.repository.UserRepository;
import com.example.task_manager.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public String createUser(User user) {
		repository.save(user);
		return String.format("User with id=%d: %s %s has been saved", user.getId(), user.getFirstName(), user.getSecondName());
	}

	@Override
	public User getUser(Long id) {
		return repository.findUserById(id);
	}

	@Override
	public String updateUser(User user) {
		repository.save(user);
		return String.format("User with id=%d has been updated", user.getId());
	}

	@Override
	public String deleteUser(Long id) {
		repository.deleteById(id);
		return String.format("User with id=%d has been deleted(", id);
	}
}
