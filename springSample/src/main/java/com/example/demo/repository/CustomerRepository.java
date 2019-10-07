package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
		List<Customer> findByName(String Name);
}
