package com.exampleMessenger.messengerBackend.user.registration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
	@Autowired
	private registrationService RegistrationService;
	@PostMapping()
	public String register (@RequestBody registrationRequest request)
	{
		return RegistrationService.register(request);
	}
	
}
