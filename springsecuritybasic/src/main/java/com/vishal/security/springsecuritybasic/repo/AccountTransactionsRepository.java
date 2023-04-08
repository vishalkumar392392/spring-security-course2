package com.vishal.security.springsecuritybasic.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vishal.security.springsecuritybasic.entity.AccountTransactions;

public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {
	
	List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
