package com.example.task_manager.service;

import com.example.task_manager.dto.TaskDTO;
import com.example.task_manager.model.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TaskService {
	List<TaskDTO> getAllUserTasks(Long userId);

	String createUserTask(TaskDTO dto);

	TaskDTO getUserTask(Long taskId);

	String updateUserTask(TaskDTO dto);

	String deleteUserTask(Long taskId);

}
