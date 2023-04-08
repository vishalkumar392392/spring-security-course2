package com.vishal.security.springsecuritybasic.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vishal.security.springsecuritybasic.entity.Customer;
import com.vishal.security.springsecuritybasic.exception.CustomException;
import com.vishal.security.springsecuritybasic.exception.ExceptionResponse;
import com.vishal.security.springsecuritybasic.repo.CustomerRepository;
import com.vishal.security.springsecuritybasic.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String save(Customer customer) {

		List<Customer> customers = customerRepository.findByEmail(customer.getEmail());
		if (!customers.isEmpty()) {
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
					new ExceptionResponse("Email Id is already registered..", "500", "INTERNAL_SERVER_ERROR"));
		}

		customer.setPwd(passwordEncoder.encode(customer.getPwd()));
		customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
		Customer cus = customerRepository.save(customer);
		if (cus != null && cus.getId() > 0) {
			return "Given User details are saved successfully";
		} else {
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
					new ExceptionResponse("Email Id is already registered..", "500", "INTERNAL_SERVER_ERROR"));
		}
	}

}
