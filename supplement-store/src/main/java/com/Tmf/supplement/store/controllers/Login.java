package com.Tmf.supplement.store.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import com.Tmf.supplement.store.entites.User;
import com.Tmf.supplement.store.services.UserService;

@Controller
@RequestMapping("/auth")
public class Login {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String showloginForm() {
	return "login";
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam String email,
			                @RequestParam String password,
			                 Model model) {
		Optional<User>userOptinal=userService.authenticate(email,password);
		if (userOptinal.isEmpty()) {
			model.addAttribute("error","Invalid email and password");
			return "login";
		}
		User user=userOptinal.get();
		if("ADMIN".equalsIgnoreCase(user.getState())) {
			return "redirect:/admin/dashboard";
		}else {
			return "redirect:/home";
		}
		
		
	}
	
	
}
