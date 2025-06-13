package com.example.demo.repository;

import com.example.demo.model.UserDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByEmail(String email);
    
	@Query("SELECT u FROM UserDetails u")
	public List<UserDetails>GetUsers();

}
