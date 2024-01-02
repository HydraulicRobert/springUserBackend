package com.exampleMessenger.messengerBackend.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleMessenger.messengerBackend.user.user;
import com.exampleMessenger.messengerBackend.user.userRights;
import com.exampleMessenger.messengerBackend.user.userService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class registrationService {
	//@Autowired
	private final userService UserService;
	//@Autowired
	private final emailValidator EmailValidator;
	public String register(registrationRequest request) {;
		boolean isValidEmail = EmailValidator
			.test(request.getEmail());
		if(!isValidEmail)
		{
			throw new IllegalStateException("email not valid");
		}
		return UserService.signUpUser(
			new user
			(
					request.getFirstName(),
					request.getLastName(),
					request.getUserName(),
					request.getEmail(),
					request.getPassword(), 
					userRights.USER
			)
		);
	}

}
