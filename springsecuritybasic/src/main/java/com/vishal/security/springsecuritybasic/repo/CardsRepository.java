package com.vishal.security.springsecuritybasic.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vishal.security.springsecuritybasic.entity.Cards;

public interface CardsRepository extends CrudRepository<Cards, Long> {
	
	List<Cards> findByCustomerId(int customerId);

}