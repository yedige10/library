package com.example.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "page")
	private long page;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "year")
	private String year;

	@Column(name = "description")
	private String description;
	
	@Column(name = "count")
	private long count;
	
	public Book(String name,Long page,String author,String photo,String code,String year,String description,Long count) {
		this.name=name;
		this.page=page;
		this.author=author;
		this.photo=photo;
		this.code=code;
		this.year=year;
		this.description=description;
		this.count=count;
	
	}
}

