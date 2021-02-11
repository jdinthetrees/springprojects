package com.johndang.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johndang.relationships.models.Person;
import com.johndang.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	//returns all the persons
	public List<Person> findAllPersons() {
		return personRepository.findAll();
		}
	
	//get one person
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
			} else {
				return null;
				}
		}
	
	//creates a language
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	//update a person
	
    public Person updatePerson(Long id, Person person) {
    	return personRepository.save(person);
	}
    

    
	
	//deletes a person
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}

}
