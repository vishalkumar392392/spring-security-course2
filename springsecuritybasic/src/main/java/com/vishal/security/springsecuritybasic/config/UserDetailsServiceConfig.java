package com.vishal.security.springsecuritybasic.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vishal.security.springsecuritybasic.entity.Customer;
import com.vishal.security.springsecuritybasic.repo.CustomerRepository;

//@Service
public class UserDetailsServiceConfig implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		String userName = null;
		String password = null;
		List<GrantedAuthority> authorities = null;

		List<Customer> customers = customerRepository.findByEmail(username);

		if (customers == null || customers.isEmpty()) {
			throw new UsernameNotFoundException("User details not found for the user: " + username);
		}
		Customer customer = customers.get(0);
		userName = customer.getEmail();
		password = customer.getPwd();
		authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(customer.getRole()));
		return new User(userName, password, authorities);
	}

}
