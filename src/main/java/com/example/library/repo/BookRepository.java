package com.example.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer>,BookRepositoryBook{
	Book findById(int id);
}
