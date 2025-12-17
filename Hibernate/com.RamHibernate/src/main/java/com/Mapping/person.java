package com.Mapping;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class person {
	private String name;
	private int age;

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	vehicle v;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public vehicle getV() {
		return v;
	}

	public void setV(vehicle v) {
		this.v = v;
	}

}
