package com.example.library.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Book;
import com.example.library.model.Requests;
import com.example.library.model.User;
import com.example.library.repo.BookRepository;
import com.example.library.repo.RequestsRepository;
import com.example.library.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/library")
public class UserController {
	@Autowired
	UserRepository userRepo;
	@Autowired
	BookRepository bookRepo;
	@Autowired
	RequestsRepository requestRepo;

	@PostMapping("/users/createuser")
	public User postUserStaff(@RequestBody User user) {
		User _user = userRepo.save(user);
		return _user;
	}

	@GetMapping("/listbooks")
	public List<Book> getAllBooks() {
		System.out.println("Get all books...");

		List<Book> news = new ArrayList<>();
		bookRepo.findAll().forEach(news::add);

		return news;
	}

	@GetMapping(value = "listbooks/{id}")
	public Book findById(@PathVariable Long id) {
		Book book = bookRepo.findById(id).get();
		return book;
	}

	@PostMapping("/createbook")
	public Book createBook(@RequestBody Book book) {
		Book _book = bookRepo.save(book);
		return _book;
	}

	@PostMapping("/users/login")
	public User loginUser(@RequestBody User user) {
		System.out.println(user.getUsername() + user.getPassword() + user.getId());

		User _user = userRepo.login(user);

		return _user;
	}

	@PostMapping("/createrequest")
	public Requests createRequest(@RequestBody Requests request) {
		Book book = bookRepo.findById(request.getBookId()).get();
		User user = userRepo.findById(request.getUserId()).get();

		request.setBook(book);
		request.setUser(user);
		request.setStartDate(LocalDateTime.now());
		Requests _request = requestRepo.save(request);
		book.setCount(book.getCount() - request.getCount());

		bookRepo.save(book);

		return _request;
	}

	@GetMapping("/requests/{id}")
	public List<Requests> getAllRequests(@PathVariable Long id) {
		System.out.println("Get  requests of the user...");
		List<Requests> requests = requestRepo.find(id);

		return requests;
	}

	@GetMapping("/allrequests")
	public List<Requests> getAllRequestss() {
		System.out.println("Get all requests...");
		List<Requests> requests = requestRepo.findAllRequests();

		return requests;
	}

	@PutMapping("/updaterequest/{id}")
	public Requests updateRequest(@PathVariable("id") long id, @RequestBody Requests request) {
		Optional<Requests> _request = requestRepo.findById(id);
		Requests r = _request.get();
		r.setStatus(request.getStatus());
		requestRepo.save(r);
		return r;
	}

	@GetMapping("/approvedrequests")
	public List<Requests> getApproves() {
		System.out.println("Get all approved requests...");
		List<Requests> requests = requestRepo.findApproves();

		return requests;
	}

	@PutMapping("/returnedequest/{id}")
	public Requests returnedRequest(@PathVariable("id") long id, @RequestBody Requests request) {
		Optional<Requests> _request = requestRepo.findById(id);
		Book book = bookRepo.findById(request.getBookId()).get();

		Requests r = _request.get();
		r.setReturnDate(LocalDateTime.now());
		r.setStatus(request.getStatus());
		book.setCount(book.getCount() + request.getCount());
		bookRepo.save(book);

		requestRepo.save(r);
		return r;
	}

	@GetMapping("/getreturnedrequests")
	public List<Requests> getReturned() {
		System.out.println("Get all returned requests...");
		List<Requests> requests = requestRepo.findReturned();

		return requests;
	}

	@GetMapping("/data")
	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return formatter.format(date);

	}
}
