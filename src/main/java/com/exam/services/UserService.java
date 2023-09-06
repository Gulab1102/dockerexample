package com.exam.services;

import java.util.Set;

import com.exam.model.User;
import com.exam.model.UserRole;

public interface UserService {
	
	//creating User
	
	public User createUser(User user,Set<UserRole> userRole) throws Exception ;
	
	//get user by username
	
	public User getUser(String userName);
     
	public void deleteUser(Long id);
}
