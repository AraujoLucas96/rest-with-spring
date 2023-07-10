package br.com.lucas.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.exceptions.ResouceNotFoundException;
import br.com.lucas.model.Person;
import br.com.lucas.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		logger.info("Findin all people!");

		return repository.findAll();
	}
	
	@Autowired
	PersonRepository repository;
	
	public Person findById(Long id) {
		
		logger.info("Findin one person!");
		
		return repository.findById(id)
				.orElseThrow(()-> new ResouceNotFoundException("No records found for this ID"));
	}
	
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
}
