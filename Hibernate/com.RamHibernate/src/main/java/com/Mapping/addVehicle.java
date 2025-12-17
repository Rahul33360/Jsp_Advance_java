package com.Mapping;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class addVehicle {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		vehicle v = new vehicle();
		v.setName("suv");

		transaction.begin();
		entityManager.persist(v);
		transaction.commit();

		System.out.println("Vehicle added");
	}
}
