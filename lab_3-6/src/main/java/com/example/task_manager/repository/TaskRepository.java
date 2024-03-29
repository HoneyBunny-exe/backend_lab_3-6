package com.example.task_manager.repository;

import com.example.task_manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
	Task findTaskById(Long taskId);
	Long deleteTaskById(Long id);
	Task findFirstByOrderByIdDesc();
}
