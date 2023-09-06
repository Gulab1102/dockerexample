package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@SpringBootApplication
public class ExamprojectApplication implements CommandLineRunner{
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	System.out.println("Starting Code");
	
//	User user=new User();
//	user.setFirstName("Gulab");
//	user.setLastName("Kumar");
//	user.setUserName("Gulab1102");
//	user.setPassword("abc");
//	user.setEmail("abc@gmail.com");
//	user.setProfile("default.png");
//	user.setPhone("6204170061");
//	
//	Role role=new Role();
//	
//	role.setRoleId(44L);
//	role.setRoleName("Admin");
//	Set<UserRole> userRoleSet=new HashSet<UserRole>();
//	
//	
//	UserRole userRole=new UserRole();
//	userRole.setRole(role);
//	
//	userRole.setUser(user);
//	
//	userRoleSet.add(userRole);
//	
//	User u=this.userService.createUser(user, userRoleSet);
//	
//	System.out.println(u.getUserName());
//	
//	
		
	}

}
