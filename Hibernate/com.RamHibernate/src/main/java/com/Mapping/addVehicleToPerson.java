package com.Mapping;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class addVehicleToPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		person person = entityManager.find(person.class, 2);
		vehicle vehicle = entityManager.find(vehicle.class, 4);
		
		entityManager.getTransaction().begin();
		person.setV(vehicle);
		entityManager.merge(person);
		entityManager.getTransaction().commit();
		
	}
}
