package com.Tmf.supplement.store.controllers;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tmf.supplement.store.entites.User;
import com.Tmf.supplement.store.services.UserService;

@Controller
@RequestMapping("/auth")
public class Register {
	@Autowired
	private UserService userService;
	
	@GetMapping("/Register")
	public String showRegisterForm() {
	return "Register";
	}
	@PostMapping
	public String registerUser(@RequestParam("pinCode") Long pinCode
			                   ,@RequestParam("state") String state
			                   ,@RequestParam("city") String city
			                   ,@RequestParam("area") String area
		                   	   ,@RequestParam("doorNo") String doorNo
		                   	   ,@RequestParam("password") String password
		                   	   ,@RequestParam("phone") String phone
		                   	   ,@RequestParam("email") String email
		                   	   ,@RequestParam("lastname") String lastName
		                   	   ,@RequestParam("firstname") String firstName
							   ,Model model) {
		if(userService.emailExists(email)) {
			model.addAttribute("error","Email already Registered.");
			return "Register";
		}
		User newUser = new User (pinCode, lastName, email, phone, password, doorNo, area, city, state, firstName);
		userService.registerUser(newUser);
		return "redirect:/auth/login";
	
	}

}
