package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.CustomerRepository;

@Controller
public class IndexController {

	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping("/top")
	public String top() {
		return "search";
	}

	@RequestMapping("/")
	public String index() {
		return "search";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/login-error")
	public String loginError() {
		return "login-error";
	}

}
