package com.example.task_manager.service.impl;

import com.example.task_manager.model.Task;
import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

	private TaskRepository repository;
	@Override
	public List<Task> getAllUserTasks(Long userId) {
		return repository.findAll();
	}

	@Override
	public String createUserTask(Task task) {
		repository.save(task);
		return String.format("Task with id=%d has been created for user with id=%d", task.getId(), task.getUserId());
	}

	@Override
	public Task getUserTask(Long taskId) {
		return repository.findTaskById(taskId);
	}

	@Override
	public String updateUserTask(Task task) {
		repository.save(task);
		return String.format("Task with id=%d has been updated", task.getId());
	}

	@Override
	public String deleteUserTask(Long taskId) {
		repository.deleteById(taskId);
		return String.format("Task with id=%d has been deleted(", taskId);
	}
}
