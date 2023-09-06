package com.exam.securityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.services.UserService;
import com.exam.services.impl.UserServiceImpl;

@Service
public class CustomUserService implements UserDetailsService{
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= userService.getUser(username);
		
	
		
		if(user==null) {
			throw new UsernameNotFoundException("UserName not  found");
		}
		
		//UserDetails userDetails=new CustomUserDetails(user);
		
		 
		return user;
	}

}
