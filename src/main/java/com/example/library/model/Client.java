package com.example.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "stafforclient")
	private String stafforclient;
	public Client(String username,String firstname,String lastname,String email,String password,String stafforclient) {
		this.username=username;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.password=password;
		this.stafforclient=stafforclient;
	}
}
