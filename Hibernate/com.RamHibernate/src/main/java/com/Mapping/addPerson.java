package com.Mapping;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class addPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		person p = new person();
		p.setName("Tam");
		p.setAge(32);

		transaction.begin();
		entityManager.persist(p);
		transaction.commit();

		System.out.println("Person added");

	}
}
