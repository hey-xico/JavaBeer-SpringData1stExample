package br.com.javabeer.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javabeer.springdatajpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	List<Person> findByFirstName(String firstName);
	Person findByEmail(String email);
}
