package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Controller
public class IndexController {

	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping("/")
	public String index(Model model) {

		Optional<Customer> customer = customerRepository.findById(1);

		model.addAttribute("name", customer.orElseThrow().getName());
		return "hello";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
