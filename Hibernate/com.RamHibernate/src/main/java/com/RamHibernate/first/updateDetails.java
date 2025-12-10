package com.RamHibernate.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class updateDetails {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student s=new Student();
		s.setName("abc");
		s.setAge(52);
		s.setId(8);
		entityManager.getTransaction().begin();
		Student merge = entityManager.merge(s);
		
		merge.setName("Car");
		entityManager.getTransaction().commit();
		
	}
}
