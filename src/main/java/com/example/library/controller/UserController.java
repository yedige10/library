package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Client;
import com.example.library.model.User;
import com.example.library.repo.ClientRepository;
import com.example.library.repo.UserRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/library")

public class UserController {
	@Autowired
	UserRepository repository;
	@Autowired
	ClientRepository repository1;
	
	@PostMapping("/users/createstaff")
	public User postUserStaff(@RequestBody User user) {
		User _user = repository.save(new User(user.getUsername(),user.getFirstname(),
				user.getLastname(),user.getEmail(),user.getPassword(),user.getStafforclient()));
		return _user;
	}
	@PostMapping("/users/createclient")
	public Client postUserClient(@RequestBody Client client) {
		Client _client = repository1.save(new Client(client.getUsername(),client.getFirstname(),
				client.getLastname(),client.getEmail(),client.getPassword(),client.getStafforclient()));
		return _client;
	}
}
