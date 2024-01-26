package com.example.task_manager.service;

import com.example.task_manager.model.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TaskService {
	List<Task> getAllUserTasks(Long userId);

	String createUserTask(Task task);

	Task getUserTask(Long taskId);

	String updateUserTask(Task task);

	String deleteUserTask(Long taskId);

}
