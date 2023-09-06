package com.exam.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.services.UserService;

@Service

public class UserServiceImpl implements UserService{
@Autowired
private UserRepository userRepository;

@Autowired
private RoleRepository roleRepository;

//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {
		// TODO Auto-generated method stub
		
		User local=userRepository.findByUserName(user.getUserName());
		if(local !=null) {
			System.out.println("User is alreadydy there !!");
			
//			throw new Exception("User is already there");
			local=null;
		}
		else {
			for(UserRole ur : userRole) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRole);
		 local=	this.userRepository.save(user);
		}
		
		return local;
	}

	//getting user by userName
	@Override
	public User getUser(String userName) {
		
		return userRepository.findByUserName(userName);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
		this.userRepository.deleteById(id);
	     
	}
	
	

}
