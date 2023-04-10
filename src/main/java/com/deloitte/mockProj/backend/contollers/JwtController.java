package com.deloitte.mockProj.backend.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.mockProj.backend.Services.CustomUserDetailsService;
import com.deloitte.mockProj.backend.Services.UserService;
import com.deloitte.mockProj.backend.entity.JwtRequest;
import com.deloitte.mockProj.backend.entity.JwtResponse;
import com.deloitte.mockProj.backend.entity.User;
import com.deloitte.mockProj.backend.helper.JwtHelper;

@RestController
@CrossOrigin(origins="*")
public class JwtController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private JwtHelper jwtUtil;
	
	//Register User
			@PostMapping("/addUser")
			private void addNewUser(@RequestBody User newUser) {
				userService.addNewUserService(newUser);
			}
		
	
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.out.println(jwtRequest); 
		try {			
			Authentication tmp = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			System.out.println(tmp);
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Username not found");
		}catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		//CHECK FOR USER OR USERDETAILS
		User userDetails= this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
