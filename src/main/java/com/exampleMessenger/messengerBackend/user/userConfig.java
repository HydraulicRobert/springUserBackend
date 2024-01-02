package com.exampleMessenger.messengerBackend.user;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class userConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(userRepository UserRepository)
	{
		return args->{
			user hans = new user("hans","joachim","hansi","hans@im.glueck","hans", userRights.USER);
			user max = new user("max","mustermann","maxi","max@im.glueck","max", userRights.USER);
			UserRepository.saveAll(
					Arrays.asList(
							hans,max
					)
			);
		};
	}
}
