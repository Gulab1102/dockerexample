package com.exam.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtHelper;
import com.exam.model.JwtRequest;
import com.exam.model.JwtResponse;
import com.exam.model.User;
import com.exam.services.impl.UserServiceImpl;


@RestController

@CrossOrigin(origins = "*")
public class AuthController {
	@Autowired
      UserServiceImpl userServiceImpl;
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;
//
//	@Autowired
//	private PasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JwtHelper helper;

	

	@PostMapping("/generate-token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest request) throws Exception {
		
		try {
			
			
			this.authenticate(request);
			
		} catch (UsernameNotFoundException e) {
			
			System.out.println("Hello"+e.getMessage());
			throw new Exception("User Not Found ");
		}
		
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
		String token = this.helper.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
  	
	}
	
	
	
	public void authenticate(JwtRequest request) throws Exception {
		
	try {
			
			manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER DISABLED "+e.getMessage());
			
		}
		catch (BadCredentialsException e) {
			throw new Exception("Invalid credentials  "+e.getMessage());
			
		
	}

	}
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return (User)this.userDetailsService.loadUserByUsername(principal.getName());
	}
}
