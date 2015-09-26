package br.com.javabeer.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.javabeer.springdatajpa.domain.Person;
import br.com.javabeer.springdatajpa.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public void save(Person p) {
		this.personRepository.save(p);
	}

	@Override
	public void deleteById(Long id) {
		this.personRepository.delete(id);
	}

	@Override
	public List<Person> findAll() {
		return this.personRepository.findAll();
	}

	@Override
	public Person findById(Long id) {
		return this.personRepository.findOne(id);
	}

	@Override
	public List<Person> findByName(String firstName) {
		return this.personRepository.findByFirstName(firstName);
	}

	@Override
	public Person findByEmail(String email) {
		return this.personRepository.findByEmail(email);
	}

}
