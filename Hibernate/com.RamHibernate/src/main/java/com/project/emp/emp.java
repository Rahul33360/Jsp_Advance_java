package com.project.emp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class emp {
	String name;
	@Id
	int id;
	int age;
	String mobile;
	char gender;
	String email;
//	char grade;
	int marks;

	public emp() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String string) {
		this.mobile = string;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	/*
	 * public char getGrade() { return grade; }
	 
	public void setGrade(char grade) {
		this.grade = grade;
	}
*/
	@Override
	public String toString() {
		return "emp [ Id= " + id + ", Name= " + name +", Age= " + age + ", Mobile=" + mobile + ", Gender= " + gender
				+ ", Email= " + email + ", Marks= " + marks + "]";
	}

}
