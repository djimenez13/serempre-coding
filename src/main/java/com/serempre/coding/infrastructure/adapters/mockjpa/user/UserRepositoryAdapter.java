package com.serempre.coding.infrastructure.adapters.mockjpa.user;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.serempre.coding.domain.model.user.User;
import com.serempre.coding.domain.model.user.gateway.UserRepository;

@Repository
public class UserRepositoryAdapter implements UserRepository {

	private final String URL = "https://jsonplaceholder.typicode.com/users";

	private RestTemplate restTemplate;
	private ModelMapper modelMapper;

	public UserRepositoryAdapter(RestTemplate restTemplate, ModelMapper modelMapper) {
		this.restTemplate = restTemplate;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<User> findAll() {

		ResponseEntity<List<UserData>> response = restTemplate.exchange(URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UserData>>() {
				});
		
		return response.getBody().stream().map(data -> modelMapper.map(data, User.class)).collect(Collectors.toList());
	}

	@Override
	public User findById(Long id) {

		try {
			UserData data = restTemplate.getForObject(new StringBuilder().append(URL).append("/").append(id).toString(),
					UserData.class);

			return modelMapper.map(data, User.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
