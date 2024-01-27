package com.example.task_manager.service.impl;

import com.example.task_manager.dto.UserDTO;
import com.example.task_manager.exceptions.DoesntExistsException;
import com.example.task_manager.model.User;
import com.example.task_manager.repository.UserRepository;
import com.example.task_manager.service.UserService;
import com.example.task_manager.utils.MappingUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private MappingUtils mapper;
	@Override
	public List<UserDTO> getAllUsers() {
		return repository.findAll().stream()
				.map(x -> mapper.userToUserDTO(x)).collect(Collectors.toList());
	}

	@Override
	public String createUser(UserDTO dto) {
		repository.save(mapper.userDTOToUser(dto));
		return String.format("User with id=%d: %s %s has been saved", repository.findFirstByOrderByIdDesc().getId(), dto.getFirstName(), dto.getSecondName());
	}

	@Override
	public UserDTO getUser(Long id) {
		User user = repository.findUserById(id);
		if(user != null)
			return mapper.userToUserDTO(user);
		throw new DoesntExistsException(String.format("User with id=%d does not exist", id));
	}

	@Override
	public String updateUser(UserDTO dto) {
		User user = repository.save(mapper.userDTOToUser(dto));
		return String.format("User with id=%d has been updated", user.getId());
	}

	@Override
	public String deleteUser(Long id) {
		Long status = repository.deleteUserById(id);
		if(status==0)
			throw new DoesntExistsException("User does not exists");

		return String.format("User with id=%d has been deleted(", id);
	}
}
