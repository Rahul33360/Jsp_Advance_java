package com.Mapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javax.persistence.Query;

public class fetchAllEmpVehicle {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select p from person p", person.class);

		List<person> list = query.getResultList();
		
		System.out.println("-------------------------");
		for (person p : list) {
			System.out.println("Person ID : " + p.getId());
			System.out.println("Name      : " + p.getName());
			System.out.println("Age       : " + p.getAge());

			if (p.getV() != null) {
				System.out.println("Vehicle   : " + p.getV().getName());
				System.out.println("Vehicle No: " + p.getV().getNum());
			} else {
				System.out.println("Vehicle   : Not Assigned");
			}

			System.out.println("-------------------------");
		}
	}
}
