package com.example.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String firstName;

private String lastName;

private double money;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public double getMoney() {
	return money;
}

public void setMoney(double money) {
	this.money = money;
}
}
