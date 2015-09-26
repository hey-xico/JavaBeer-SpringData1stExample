package br.com.javabeer.springdatajpa.service;

import java.util.List;

import br.com.javabeer.springdatajpa.domain.Person;

public interface PersonService {
	void save(Person p);
	void deleteById(Long id);
	List<Person> findAll();
	Person findById(Long id);
	List<Person> findByName(String firstName);
	Person findByEmail(String email);
}
