package com.exampleMessenger.messengerBackend.user.registration;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
//@RequestMapping(path="/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
	private registrationService RegistrationService;
	@PutMapping("/registration")
	public String register (@RequestBody registrationRequest request)
	{
		return RegistrationService.register(request);
	}
	
}
