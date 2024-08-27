package com.serempre.coding.domain.usecase.user;

import java.util.List;

import com.serempre.coding.domain.model.exception.ResourceNotFoundException;
import com.serempre.coding.domain.model.user.User;
import com.serempre.coding.domain.model.user.gateway.UserRepository;

public class UserUseCase {
	
	private UserRepository repository;

	public UserUseCase(UserRepository repository) {
		this.repository = repository;
	}
	
	
	public List<User> getUsers() {
		
		return repository.findAll();
	}
	
	public User getUserById(Long id) {
		
		User userFound = repository.findById(id);
		
		if (userFound == null) {
			throw new ResourceNotFoundException("User not found");
		}
		
		return userFound;
	}
}
