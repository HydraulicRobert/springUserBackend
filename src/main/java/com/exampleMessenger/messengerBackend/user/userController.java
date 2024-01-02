package com.exampleMessenger.messengerBackend.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/getUserById/{id}")
	public Optional<user> getUserById(@PathVariable("id") int id)
	{
		return UserService.findUserById((long)id) ;
		
	}
	@DeleteMapping("/deleteById/{id}")
	public void deleteUserById(@PathVariable("id") int id)
	{
		UserService.deleteUserById(id);
	}
}
