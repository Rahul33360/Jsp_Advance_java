package com.RamHibernate.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class persistenceAndMerge {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student s = entityManager.find(Student.class, 1);
		entityManager.getTransaction().begin();

		s.setName("raa");
		entityManager.persist(s);
		s.setName("asdf");
		entityManager.getTransaction().commit();

	}

}
