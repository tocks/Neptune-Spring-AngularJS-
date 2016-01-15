package com.neptune.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neptune.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("select u from User u where u.username=:x")
	public User getUserByUsername(@Param("x")String username);

}
