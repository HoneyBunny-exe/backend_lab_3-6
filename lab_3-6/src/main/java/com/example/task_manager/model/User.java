package com.example.task_manager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "\"user\"")
@Entity
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

	@Column(name = "age")
	private Integer age;


	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Task> taskList;
	//Каскадное удаление
}
