package com.example.task_manager.dto;

import com.example.task_manager.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
	private Long id;
	private String firstName;
	private String secondName;
	private LocalDateTime dateOfBirthday;
	private List<Task> taskList;

	// Только в dto, высчитываются в MappingUtils
	private Long age;
}
