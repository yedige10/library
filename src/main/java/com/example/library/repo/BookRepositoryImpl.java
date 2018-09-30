package com.example.library.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.library.model.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BookRepositoryImpl implements BookRepositoryBook{
	@PersistenceContext
    EntityManager entityManager;

	@SuppressWarnings("unchecked")
	
	public Book namecount(Book book) {
        Query query = entityManager.createNativeQuery("SELECT name,count FROM user",Book.class);
        return book;
	}

	}

