package com.exampleMessenger.messengerBackend.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
	private userService UserService;
	@Autowired
	public userController(userService UserService)
	{
		this.UserService = UserService;
	}
	
	@GetMapping("/getAllUsers")
	public List<user> getAllUsers()
	{
		return UserService.findAll();
	}
}
