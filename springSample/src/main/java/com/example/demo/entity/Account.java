package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account {

	protected Account(){}

	public Account(Integer id ,String username,String password,boolean isAdmin){
		setId(id);
		setUsername(username);
		setPassword(password);
		setEnabled(true);
		setAdmin(isAdmin);
	}

	@Id
	@Column(nullable = false, unique = true)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
    private boolean enabled;

	@Column(nullable = false)
    private boolean admin;
}
