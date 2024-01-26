package com.example.task_manager.utils;

import com.example.task_manager.dto.TaskDTO;
import com.example.task_manager.dto.UserDTO;
import com.example.task_manager.model.Task;
import com.example.task_manager.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Service;

import javax.xml.datatype.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class MappingUtils {
	public TaskDTO taskToTaskDTO(Task task){
		TaskDTO dto = new TaskDTO(
				task.getId(),
				task.getTaskName(),
				task.getTaskDescription(),
				task.getStartDate(),
				task.getFinishDate(),
				task.getStatus(),
				task.getUserId(),
				null
		);

		LocalDateTime tempDateTime = LocalDateTime.from( dto.getStartDate() );

		long years = tempDateTime.until( dto.getFinishDate(), ChronoUnit.YEARS );
		tempDateTime = tempDateTime.plusYears( years );

		long months = tempDateTime.until( dto.getFinishDate(), ChronoUnit.MONTHS );
		tempDateTime = tempDateTime.plusMonths( months );

		long days = tempDateTime.until( dto.getFinishDate(), ChronoUnit.DAYS );
		tempDateTime = tempDateTime.plusDays( days );


		long hours = tempDateTime.until( dto.getFinishDate(), ChronoUnit.HOURS );
		tempDateTime = tempDateTime.plusHours( hours );

		long minutes = tempDateTime.until( dto.getFinishDate(), ChronoUnit.MINUTES );
		tempDateTime = tempDateTime.plusMinutes( minutes );

		long seconds = tempDateTime.until( dto.getFinishDate(), ChronoUnit.SECONDS );

		dto.setDuration(years + " years " +
				months + " months " +
				days + " days " +
				hours + " hours " +
				minutes + " minutes " +
				seconds + " seconds.");

		return dto;
	}

	public Task taskDtoToTask(TaskDTO dto){
		return new Task(
				dto.getId(),
				dto.getTaskName(),
				dto.getTaskDescription(),
				dto.getStartDate(),
				dto.getFinishDate(),
				dto.getStatus(),
				dto.getUserId()
		);
	}

	public UserDTO userToUserDTO(User user){

		LocalDateTime tempDateTime = LocalDateTime.from( user.getDateOfBirthday() );

		long years = tempDateTime.until( LocalDateTime.now(), ChronoUnit.YEARS );

		return new UserDTO(
				user.getId(),
				user.getFirstName(),
				user.getSecondName(),
				user.getDateOfBirthday(),
				user.getTaskList(),
				years
		);
	}

	public User userDTOToUser(UserDTO dto){
		return new User(
		dto.getId(),
		dto.getFirstName(),
		dto.getSecondName(),
		dto.getDateOfBirthday(),
		dto.getTaskList()
		);
	}
}
