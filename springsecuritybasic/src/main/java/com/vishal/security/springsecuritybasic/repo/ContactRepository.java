package com.vishal.security.springsecuritybasic.repo;

import org.springframework.data.repository.CrudRepository;

import com.vishal.security.springsecuritybasic.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
