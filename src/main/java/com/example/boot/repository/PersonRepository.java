package com.example.boot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.boot.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Serializable>{

	public List<Person> findByLastName(String lastName) ;
	
	@Query("select u from Person u where u.lastName like ?1%")
	List<Person> findByAndSort(String lastName, Sort sort);
	
	@Query("select u from Person u where u.firstName like ?1%")
	List<Person> findByAndSortByFirstName(String firstName, Sort sort);
}
