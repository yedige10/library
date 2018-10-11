package com.example.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.User;



public interface UserRepository extends  JpaRepository<User, Long>,LoginRepository{

}
