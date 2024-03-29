package com.example.task_manager.repository;

import com.example.task_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserById(Long id);

	Long deleteUserById(Long id);

	User findFirstByOrderByIdDesc();
}
