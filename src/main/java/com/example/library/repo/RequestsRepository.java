package com.example.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Long>, RequestsRepositoryRequests {

}
