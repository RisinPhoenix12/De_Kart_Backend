package com.deloitte.mockProj.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deloitte.mockProj.backend.Repository.UserRepo;
import com.deloitte.mockProj.backend.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	User currUser;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void addNewUserService(User newUser) {

		currUser.setUsername(newUser.getUsername());
		currUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		currUser.setRole(newUser.getRole());
		currUser.setAddress(newUser.getAddress());
		userRepo.save(currUser);
	}
}
