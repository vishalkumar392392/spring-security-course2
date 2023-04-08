package com.vishal.security.springsecuritybasic.repo;

import org.springframework.data.repository.CrudRepository;

import com.vishal.security.springsecuritybasic.entity.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}

