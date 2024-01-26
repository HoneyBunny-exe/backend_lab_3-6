package com.example.task_manager.service.impl;

import com.example.task_manager.dto.TaskDTO;
import com.example.task_manager.model.Task;
import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.service.TaskService;
import com.example.task_manager.utils.MappingUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;
	@Autowired
	private MappingUtils mapper;
	@Override
	public List<TaskDTO> getAllUserTasks(Long userId) {

		return repository.findAll().stream()
				.map(x -> mapper.taskToTaskDTO(x)).collect(Collectors.toList());
	}

	@Override
	public String createUserTask(TaskDTO dto) {
		repository.save(mapper.taskDtoToTask(dto));
		return String.format("Task with id=%d has been created for user with id=%d", repository.findFirstByOrderByIdDesc().getId(), dto.getUserId());
	}

	@Override
	public TaskDTO getUserTask(Long taskId) {
		return mapper.taskToTaskDTO(repository.findTaskById(taskId));
	}

	@Override
	public String updateUserTask(TaskDTO dto) {
		repository.save(mapper.taskDtoToTask(dto));
		return String.format("Task with id=%d has been updated", dto.getId());
	}

	@Override
	public String deleteUserTask(Long taskId) {
		repository.deleteById(taskId);
		return String.format("Task with id=%d has been deleted(", taskId);
	}
}
