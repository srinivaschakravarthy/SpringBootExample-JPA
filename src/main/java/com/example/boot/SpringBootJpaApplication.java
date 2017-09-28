package com.example.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.model.Person;
import com.example.boot.repository.PersonRepository;

@SpringBootApplication
@RestController
public class SpringBootJpaApplication {

	@Autowired
	PersonRepository repo;
	
	@RequestMapping("/person")
	public String addPerson() {
		Person person = new Person();
		person.setFirstName("Lame");
		person.setLastName("Mark");
		person.setMoney(90.09);
		repo.save(person);
		return "Added Record";
		
	}
	
	@RequestMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") Long id) {
		Person p = repo.findOne(id);
		return p;
	}
	
	@RequestMapping("/person/count")
	public String countPerson() {
		Long p = repo.count();
		return p.toString();
	}
	
	@RequestMapping("/person/last/{last}")
	public List<Person> getPersonByLastName(@PathVariable("last") String last) {
		List<Person> p = repo.findByLastName(last);
		return p ;
	}
	
	@RequestMapping("/person/update/{id}/name/{name}")
	public Person updatePerson(@PathVariable("id") Long id, @PathVariable("name") String str) {
		Person p = repo.findOne(id);
		p.setFirstName(str);
		repo.save(p);
		return p ;
	}
	
	@RequestMapping("/page")
	public String pageRes(){
		return null;
		
	}
	
	@RequestMapping("/findByLastName/{name}")
	public List<Person> findByLastName( @PathVariable("name") String lastName){
		List<Person> persons = repo.findByAndSort(lastName, new Sort("firstName"));
		return persons;
	}
	
	@RequestMapping("/findByFirstName/{name}")
	public List<Person> findByFirstName( @PathVariable("name") String firstName){
		List<Person> persons = repo.findByAndSortByFirstName(firstName, new Sort("firstName"));
		return persons;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
}
