package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerServcie;

@Controller
public class CustomerSearchController {

	@Autowired
	CustomerServcie customerService;

	@RequestMapping("/search")
	public String top(@RequestParam(name = "id", required = false) Optional<Integer> id, Model model) {

		if (id.isEmpty()) {
			List<Customer> customers = customerService.findAll();
			model.addAttribute("customers", customers);
		} else {
			Customer customer = customerService.findById(id.get());
			model.addAttribute("name", customer.getName());
		}



		return "result";
	}

}
