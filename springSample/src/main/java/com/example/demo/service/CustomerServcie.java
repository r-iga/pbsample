package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServcie {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> findAll() {

		List<Customer> customers = new ArrayList<>();

		customerRepository.findAll().forEach(customer -> {
			customers.add(customer);
		});

		return customers;
	}

	public Customer findById(Integer id) {
		return customerRepository.findById(id).orElseThrow();
	}

}
