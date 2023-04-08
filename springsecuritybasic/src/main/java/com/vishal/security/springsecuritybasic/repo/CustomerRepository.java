package com.vishal.security.springsecuritybasic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.security.springsecuritybasic.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByEmail(String username);

}
