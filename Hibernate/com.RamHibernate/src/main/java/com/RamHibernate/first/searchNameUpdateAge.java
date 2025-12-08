package com.RamHibernate.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class searchNameUpdateAge {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String hql = "Select e from Student e where e.name=?1";
		Query query = entityManager.createQuery(hql);
		Query setParameter = query.setParameter(1, "H");// searching we use setParameter(delimeter, searching value)
		Student st = (Student) setParameter.getSingleResult();
		st.setAge(333);
		transaction.begin();
		entityManager.merge(st);
		transaction.commit();
	
	
	}
}
