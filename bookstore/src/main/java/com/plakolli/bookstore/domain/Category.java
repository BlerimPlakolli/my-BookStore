package com.plakolli.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {
		super();
	}


	public Category(String name) {
		super();
		this.name = name;
	}

	
public Long getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}


	/*
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

*/
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}
