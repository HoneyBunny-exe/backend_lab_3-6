package com.example.task_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
public class Task {
	public Task(){}

	@Column(name = "id")
	@jakarta.persistence.Id
	@GeneratedValue
	private Long Id;

	@Column(name = "task_name", nullable = false)
	private String taskName;

	@Column(name = "task_description")
	private String taskDescription;

	@Column(name = "start_date", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "finish_date", nullable = false)
	private LocalDateTime finishDate;

	@Column(name = "status", nullable = false)
	private Boolean status;

	@Column(name = "user_id", nullable = false)
	private Long userId;
}
