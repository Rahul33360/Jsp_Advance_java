package com.RamHibernate.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class updateDataMerge {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student s = entityManager.find(Student.class, 1);
		entityManager.close();
		
		
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		entityManager2.getTransaction().begin();
		Student merge = entityManager2.merge(s);
		//s.setName("tab");// detached
		merge.setName("taa");// new copy of merge
		entityManager2.getTransaction().commit();		
	
	}

}
