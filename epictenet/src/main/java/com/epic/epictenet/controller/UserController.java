package com.epic.epictenet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic.epictenet.exception.DataNotFoundException;
import com.epic.epictenet.model.User;
import com.epic.epictenet.repo.UserRepository;



@RestController

public class UserController {

	@Autowired
 private UserRepository userRepository;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user)
	{
	        if (userRepository.existsByUsername(user.getUsername())){
	            throw new DataNotFoundException();
	        }
	        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword()); 
	        user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
	
	@GetMapping("/getuser")
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}

}
