package com.exampleMessenger.messengerBackend.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class userService implements UserDetailsService {
	private final static String USER_NOT_FOUND_msg = "user with email %s not found";
	private final userRepository UserRepository;
	@Autowired
	public userService(userRepository UserRepository)
	{
		this.UserRepository = UserRepository;
	}
	
	public List<user> findAll()
	{
		return UserRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return UserRepository.findByEmail(email)
				.orElseThrow(()->new UsernameNotFoundException(
						String.format(USER_NOT_FOUND_msg,email)
					)
				);
	}

}
