package com.example.library.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Client;
//import com.example.library.model.Requests;
import com.example.library.model.User;
import com.example.library.model.Requests;

import com.example.library.model.Book;
import com.example.library.repo.BookRepository;
import com.example.library.repo.ClientRepository;
import com.example.library.repo.RequestsRepository;
//import com.example.library.repo.RequestsRepository;
import com.example.library.repo.UserRepository;


import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.example.library.model.User;



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
	@Autowired
	RequestsRepository repository3;
	
	@PostMapping("/users/createuser")
	public User postUserStaff(@RequestBody User user) {
		User _user = repository.save(new User(user.getUsername(),user.getFirstname(),
				user.getLastname(),user.getEmail(),user.getPassword(),user.getStafforclient()));
		return _user;
	}
	/*
	@PostMapping("/users/createclient")
	public Client postUserClient(@RequestBody Client client) {
		Client _client = repository1.save(new Client(client.getUsername(),client.getFirstname(),
				client.getLastname(),client.getEmail(),client.getPassword(),client.getStafforclient()));
		return _client;
	}
	*/

	@GetMapping("/listbooks")
	public List<Book> getAllBooks() {
		System.out.println("Get all books...");

		List<Book> news = new ArrayList<>();
		repository2.findAll().forEach(news::add);

		return news;
	}
	/*
	@GetMapping("/requests")
	public List<Requests> getAllRequests() {
		System.out.println("Get all requests...");

		List<Requests> requests = new ArrayList<>();
		repository3.findAll().forEach(requests::add);
		System.out.println(requests);
		return requests;
	}
	*/
	@GetMapping(value = "listbooks/{id}")
	public Book findById(@PathVariable Long id) {
		Book book = repository2.findById(id).get();
		return book;
	}
	@PostMapping("/createbook")
	public Book createBook(@RequestBody Book book) {
		Book _book = repository2.save(new Book(book.getName(),book.getPage(),
				book.getAuthor(),book.getCode(),book.getYear(),book.getDescription(),book.getCount()));
		return _book;
	}
	@PostMapping("/users/login")
	public User loginUser(@RequestBody User user) {
		System.out.println(user.getUsername()+user.getPassword()+user.getId());
	
		User _user=repository.login(new User(user.getUsername(), user.getPassword()));
	
			
		return _user;
}
	@PostMapping("/createrequest")
	public Requests createRequest(@RequestBody Requests request) {
        Requests _request = repository3.save(new Requests(request.getId(),request.getBookId(),request.getCount(),
        		request.getStartdate(),request.getStatus(),request.getUserId()));
        System.out.println(request.getBookId()+" "+request.getUserId());
		return _request;
	}
	
	@GetMapping("/requests/{id}")
	public List<Requests> getAllRequests(@PathVariable Long id) {
		System.out.println("Get  requests of the user...");
		List<Requests> requests = repository3.find(id);
		
		return requests;
	}
	
	@GetMapping("/allrequests")
	public List<Requests> getAllRequestss() {
		System.out.println("Get all requests...");
		List<Requests> requests = repository3.findAllRequests();
		
		return requests;
	}
	
	
	@PutMapping("/updaterequest/{id}")
	public Requests updateRequest(@PathVariable("id") long id,@RequestBody Requests request) {
        Optional<Requests> _request = repository3.findById(id);
        Requests r=_request.get();
        r.setStatus(request.getStatus());
        repository3.save(r);
        return r;
	}
	@GetMapping("/approvedrequests")
	public List<Requests> getApproves() {
		System.out.println("Get all approved requests...");
		List<Requests> requests = repository3.findApproves();
		
		return requests;
	}												
												
	@PutMapping("/returnedequest/{id}")
	public Requests returnedRequest(@PathVariable("id") long id,@RequestBody Requests request) {
        Optional<Requests> _request = repository3.findById(id);
        Requests r=_request.get();
        r.setStatus(request.getStatus());
        repository3.save(r);
        return r;
	}
	
	@GetMapping("/getreturnedrequests")
	public List<Requests> getReturned() {
		System.out.println("Get all returned requests...");
		List<Requests> requests = repository3.findReturned();
		
		return requests;
	}
}
