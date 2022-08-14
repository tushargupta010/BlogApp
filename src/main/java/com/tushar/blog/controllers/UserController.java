package com.tushar.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.blog.payloads.ApiResponse;
import com.tushar.blog.payloads.UserDto;
import com.tushar.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.CREATED);
	}
	
	// PUT-update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") int userId) {
		UserDto updatedUserDto = this.userService.updateUser(userDto, userId);
		//return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.OK);
		return ResponseEntity.ok(updatedUserDto);
	}
	
	// DELETE-delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId) {
		this.userService.deleteUser(userId);
		ApiResponse response = new ApiResponse("User deleted successfully.", true, HttpStatus.OK);
		return ResponseEntity.ok(response);
	
	}
	/*public ResponseEntity<?> deleteUser(@PathVariable int userId) {
		this.userService.deleteUser(userId);
		return ResponseEntity.ok(Map.of("message", String.format("User %l deleted successfully.", userId)));
	}*/
	
	// GET-get user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<List<UserDto>>(this.userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
}
