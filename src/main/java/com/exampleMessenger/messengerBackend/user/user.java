package com.exampleMessenger.messengerBackend.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="userData")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class user implements UserDetails{
	public user(
			String firstName, 
			String lastName, 
			String userName, 
			String email, 
			String password,
			userRights UserRights
			) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.UserRights = UserRights;
	}

	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, 
			generator="user_sequence"
	)
	
	private long userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private userRights UserRights;
	private boolean locked = false;
	private boolean enabled = false;
	public long getUserId() {
		return userId;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(UserRights.name());
		return Collections.singleton(authority);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
