package com.serempre.coding.domain.model.user.gateway;

import java.util.List;

import com.serempre.coding.domain.model.user.User;

public interface UserRepository {
	
	List<User> findAll();
	User findById(Long id);

}
