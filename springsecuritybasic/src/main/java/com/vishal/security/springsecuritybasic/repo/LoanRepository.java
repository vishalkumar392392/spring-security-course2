package com.vishal.security.springsecuritybasic.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vishal.security.springsecuritybasic.entity.Loans;

public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
