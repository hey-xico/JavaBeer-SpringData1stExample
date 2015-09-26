package br.com.javabeer.springdatajpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private Long personId;
	@Column(nullable = false, name = "firstname")
	private String firstName;
	@Column(nullable = false, name = "lastname")
	private String lastName;
	@Column(nullable = false, name = "email")
	private String email;
	@Column(nullable = false, name = "phone")
	private String phone;

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getPersonId() {
		return personId;
	}

	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}