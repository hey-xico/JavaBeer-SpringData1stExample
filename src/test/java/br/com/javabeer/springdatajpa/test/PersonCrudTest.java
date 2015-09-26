package br.com.javabeer.springdatajpa.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.javabeer.springdatajpa.Application;
import br.com.javabeer.springdatajpa.domain.Person;
import br.com.javabeer.springdatajpa.service.PersonService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class PersonCrudTest {
	
	private Person person;
	
	@Autowired
	private PersonService personService;
	
	@Before
	public void setup() {
		person = new Person();
	}
	
	@Test
	public void TryToSaveAPerson() {
		person.setFirstName("Francisco");
		person.setLastName("Almeida");
		person.setEmail("francisco.almeida@outlook.com");
		person.setPhone("11999888777");
		this.personService.save(person);
		Assert.assertEquals("Deve encontrar um registro com o primeiro nome:: Francisco",
				"Francisco",
				personService.findByName("Francisco").get(0).getFirstName());
	}
	
	@Test
	public void ListAllPersons() {
		List<Person> persons = personService.findAll();
		Assert.assertNotNull(persons);
	}
	
	@Test
	public void TryToFindByFirstName() {
		Assert.assertEquals("Deve encontrar um registro com o primeiro nome:: Leia",
				"Leia",
				personService.findByName("Leia").get(0).getFirstName());
	}
	
	@Test
	public void TryToFindByEmail() {
		Assert.assertEquals("Deve encontrar um registro com o email:: luke@sw.com",
				"luke@sw.com",
				personService.findByEmail("luke@sw.com").getEmail());
	}
	
	@Test
	public void TryToDelete() {
		Person person = personService.findByEmail("han@sw.com");
		personService.deleteById(person.getPersonId());
		Assert.assertNull(personService.findByEmail("han@sw.com"));
	}
	
	
}
