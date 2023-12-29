package com.exampleMessenger.messengerBackend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional()
public interface userRepository extends JpaRepository<user, Long>{
	
	Optional<user>findByEmail(String email);
}
