package com.tushar.blog.services;

import java.util.List;

import com.tushar.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, int userId);
	UserDto getUserById(int userId);
	List<UserDto> getAllUsers();
	void deleteUser(int userId);

}
