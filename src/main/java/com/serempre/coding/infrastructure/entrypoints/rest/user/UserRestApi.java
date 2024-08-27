package com.serempre.coding.infrastructure.entrypoints.rest.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serempre.coding.domain.model.user.User;
import com.serempre.coding.domain.usecase.user.UserUseCase;

@RestController
@RequestMapping("/users")
public class UserRestApi {
	
	private UserUseCase usecase;

	public UserRestApi(UserUseCase usecase) {
		this.usecase = usecase;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		
		return ResponseEntity.ok(usecase.getUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		
		return ResponseEntity.ok(usecase.getUserById(id));
	}

}
