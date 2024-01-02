package com.exampleMessenger.messengerBackend.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class userService implements UserDetailsService {
	private final static String USER_NOT_FOUND_msg = "user with email %s not found";
	private final userRepository UserRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	//@Autowired
	/*public userService(userRepository UserRepository)
	{
		this.UserRepository = UserRepository;
	}*/
	
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
	
	public Optional <user> findUserById(long id)
	{
		return UserRepository.findById(id);
	}
	
	public String signUpUser(user User)
	{
		boolean isPresentEmail = UserRepository.findByEmail(User.getEmail()).isPresent();
		if(isPresentEmail)
		{
			throw new IllegalStateException("user with email exists");
		}
		String encodedPassword = bCryptPasswordEncoder
				.encode(User.getPassword());
		User.setPassword(encodedPassword);
		UserRepository.save(User);
		//TODO send confirmation token
		return null;
	}
	public void deleteUserById(long id)
	{
		UserRepository.deleteById(id);
	}
}
