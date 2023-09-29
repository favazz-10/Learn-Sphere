package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Users;
import com.learnSphere.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UsersService uservice;
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute Users user) {
		String email=user.getEmail();
		boolean isPresent=uservice.checkEmail(email);
		if(isPresent==false) {
			uservice.addUser(user);
		}
		else {
			System.out.println("email already present");
		}
		
		return "login";
	}
	
	@PostMapping("/validateUser")
	public String validateUser(@RequestParam("email")String email,
			                    @RequestParam("password")String password,
			                    HttpSession session) {
		
		Users user=uservice.findUserByEmail(email);
		String upass=user.getPassword();
		String urole=user.getRole();
		if(password.equals(upass)) {
			
			session.setAttribute("loggedInUser", user);
			if(urole.equals("Trainer")) {
				return "trainerHome";
			}
			else {
				return "studentHome";
			}
			
		}
		else {
		return "login";
		}
	}
}

