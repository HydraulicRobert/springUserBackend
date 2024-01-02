package com.exampleMessenger.messengerBackend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampleMessenger.messengerBackend.user.user;
import com.exampleMessenger.messengerBackend.user.userService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class webSecurityConfig {
@Autowired
private userService UserService;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
    	/*
    	http
        	.authorizeHttpRequests((auth)->auth
        		.anyRequest().authenticated()
        	)
        	.httpBasic(withDefaults()
        );
        */
    	http.csrf(csrf ->csrf.disable());
        return http.build();
    }
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.authenticationProvider(daoAuthentificationProvider());
    	
    }
    @Bean
    public DaoAuthenticationProvider daoAuthentificationProvider()
    {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setPasswordEncoder(bCryptPasswordEncoder);
    	provider.setUserDetailsService(UserService);
    	return provider;
    }
}
