package com.Tmf.supplement.store.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tmf.supplement.store.entites.User;
import com.Tmf.supplement.store.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public boolean emailExists(String email) {
		return userRepository.findByEmail(email).isPresent();
		
	}
	public void registerUser(User user) {
		userRepository.save(user);
	}
	public Optional<User>authenticate(String email,String password){
		return userRepository.findByEmailAndPassword(email, password);
	}
	

}
