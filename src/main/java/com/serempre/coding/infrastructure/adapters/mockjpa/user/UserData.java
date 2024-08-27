package com.serempre.coding.infrastructure.adapters.mockjpa.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

	private Long id;
	private String name;
	private String username;
	private String email;
}
