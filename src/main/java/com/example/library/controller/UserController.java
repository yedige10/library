package com.example.library.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Client;
import com.example.library.model.User;

import com.example.library.model.Book;
import com.example.library.repo.BookRepository;
import com.example.library.repo.ClientRepository;
import com.example.library.repo.UserRepository;


import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/library")

public class UserController {
	@Autowired
	UserRepository repository;
	@Autowired
	ClientRepository repository1;
	@Autowired
	BookRepository repository2;
	
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

	@GetMapping("/listbooks")
	public List<Book> getAllBooks() {
		System.out.println("Get all books...");

		List<Book> news = new ArrayList<>();
		repository2.findAll().forEach(news::add);

		return news;
	}
	@GetMapping(value = "listbooks/{id}")
	public Book findById(@PathVariable int id) {
		Book book = repository2.findById(id);
		return book;
	}
}
