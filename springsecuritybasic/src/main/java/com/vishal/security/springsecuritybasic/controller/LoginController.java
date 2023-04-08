package com.vishal.security.springsecuritybasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.security.springsecuritybasic.entity.Customer;
import com.vishal.security.springsecuritybasic.repo.CustomerRepository;
import com.vishal.security.springsecuritybasic.service.CustomerService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/register")
	public String registerUser(@RequestBody Customer customer) {

		return customerService.save(customer);
	}

	@GetMapping("/user")
	public Customer getUserDetailsAfterLogin(Authentication authentication, HttpServletResponse response) {
		List<Customer> customers = customerRepository.findByEmail(authentication.getName());
		Customer customer = customers.get(0);
		customer.setJwtToken(response.getHeader("Authorization"));
		if (customers.size() > 0) {
			return customer;
		} else {
			return null;
		}

	}
}
