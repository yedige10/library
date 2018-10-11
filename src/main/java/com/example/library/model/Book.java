package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "page")
	private Long page;

	@Column(name = "author")
	private String author;

	@Column(name = "code")
	private String code;

	@Column(name = "year")
	private String year;

	@Column(name = "description")
	private String description;

	@Column(name = "count")
	private Long count;

	// @OneToOne(mappedBy = "book")
	// private Requests request;

	public Book(String name, Long page, String author, String code, String year, String description, Long count) {
		this.name = name;
		this.page = page;
		this.author = author;

		this.code = code;
		this.year = year;
		this.description = description;
		this.count = count;

	}
}
