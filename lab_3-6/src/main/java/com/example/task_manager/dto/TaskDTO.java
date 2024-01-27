package com.example.task_manager.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TaskDTO {
	private Long Id;
	private String taskName;
	private String taskDescription;
	private LocalDateTime startDate;
	private LocalDateTime finishDate;
	private Boolean status;
	private Long userId;

	// Только в dto, высчитываются в MappingUtils
	private String duration;
}
