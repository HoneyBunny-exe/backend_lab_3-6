package com.example.task_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;

@Entity
@Table(name = "task")
@Data
public class Task {
	public Task(){}

	@Column(name = "id")
	@jakarta.persistence.Id
	@GeneratedValue
	private Long Id;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "task_description")
	private String taskDescription;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "finish_date")
	private LocalDate finishDate;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "user_id")
	private Long userId;
}
