package com.exampleMessenger.messengerBackend.user.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class emailValidator implements Predicate<String>{

	@Override
	public boolean test(String t) {
		// TODO regex to validate email
		return true;
	}

}
