package com.example.library.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>,BookRepositoryBook{
	Optional<Book> findById(Long id);
}
