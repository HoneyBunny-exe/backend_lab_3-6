package com.example.task_manager.controller;

import com.example.task_manager.dto.TaskDTO;
import com.example.task_manager.model.Task;
import com.example.task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users/tasks")
public class TaskController {
	@Autowired
	private TaskService service;

	@GetMapping("")
	public List<TaskDTO> getAllUserTasks(@RequestParam(name="user_id") Long userId){
		return service.getAllUserTasks(userId);
	}

	@PostMapping("create_task")
	public String createUserTask(@RequestBody TaskDTO dto){
		return service.createUserTask(dto);
	}

	@GetMapping("/{task_id}")
	public TaskDTO getUserTask(@PathVariable(name="task_id") Long taskId) {
		return service.getUserTask(taskId);
	}

	@PutMapping("update_task")
	public String updateUserTask(@RequestBody TaskDTO dto) {
		return service.updateUserTask(dto);
	}

	@DeleteMapping("delete_task/{task_id}")
	public String deleteUserTask(@PathVariable(name="task_id") Long taskId){
		return service.deleteUserTask(taskId);
	}


}
