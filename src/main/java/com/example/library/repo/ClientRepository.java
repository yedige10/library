package com.example.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Client;


public interface ClientRepository extends  JpaRepository<Client, Long> {

}
