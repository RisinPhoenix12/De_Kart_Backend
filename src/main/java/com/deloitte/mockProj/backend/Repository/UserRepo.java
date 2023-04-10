package com.deloitte.mockProj.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.deloitte.mockProj.backend.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM USER WHERE username = ?1", nativeQuery = true)
	User findByUsername(String username);;
	
	@Query(value = "SELECT username,password FROM USER WHERE username = ?1", nativeQuery = true)
	User findByLoginDetails(String username);
}
