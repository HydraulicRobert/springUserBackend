package com.exampleMessenger.messengerBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class passwordEncoder {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
//		bCryptPasswordEncoder().encode("hello");
		return new BCryptPasswordEncoder();
	}
}
