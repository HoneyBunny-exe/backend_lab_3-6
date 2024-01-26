package com.example.task_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "\"user\"")
@Entity
@AllArgsConstructor
public class User {
	public User(){}

	@Column(name="id")
	@jakarta.persistence.Id
	@GeneratedValue
	private Long Id;

	@Column(name="first_name")
	private String firstName;

	@Column(name = "second_name")
	private String secondName;

	@Column(name = "birthday")
	private LocalDateTime dateOfBirthday;


	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Task> taskList;
	//Каскадное удаление
}

// Меняем классы модели так, чтобы они хранили как можно меньше информации. При том создаем дто, которые будут
// хранить данные, которые существенны для фронта (контроллера, так как он передает эти данные фронту)