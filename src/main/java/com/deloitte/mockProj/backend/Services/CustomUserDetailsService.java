package com.deloitte.mockProj.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deloitte.mockProj.backend.Repository.UserRepo;
import com.deloitte.mockProj.backend.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService  {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	User currUser;
	
	
	//USER USERDETAILS CHK
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		currUser = userRepo.findByUsername(username);
		
		if(currUser != null && currUser.getUsername().equals(username)) {
			System.out.println(currUser);
			return currUser;
		}
		else {
			throw new UsernameNotFoundException("User Not Found !!!");
		}

	}
	
	

	
}
