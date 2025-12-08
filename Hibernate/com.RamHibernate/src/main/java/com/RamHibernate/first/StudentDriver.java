package com.RamHibernate.first;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDriver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
//		Random r = new Random();
//		int id = r.nextInt(9);
		
		Student s1 = new Student();
		s1.setName("R");
		s1.setAge(12);
		s1.setId(1);
		
		Student s2 = new Student();
		s2.setName("A");
		s2.setAge(12);
		s2.setId(2);	
		
		transaction.begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		transaction.commit();		
//		System.out.println("Table Created");
		
	}
}
