package com.learnSphere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/addC")
	public String addC(){
		return "addCourse";
	}
	
	@GetMapping("/addL")
	public String addL() {
		return "addLesson";
	}
}
