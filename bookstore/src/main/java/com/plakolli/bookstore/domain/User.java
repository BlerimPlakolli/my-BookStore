package com.plakolli.bookstore.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable=false)
	private Long id;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="password", nullable=false)
	private String passwordHash;
	
	@Column(name="email")
	public String email;
	
	@Column(name="role", nullable=false)
	public String role;
	
	
	
	
	

}
