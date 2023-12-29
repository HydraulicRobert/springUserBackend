package com.exampleMessenger.messengerBackend.user.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class registrationRequest {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
}
