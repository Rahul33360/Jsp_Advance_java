package com.RamHibernate.first;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class fetchByAge {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		/* For fetching
		 * String hql = "Select e from Student e"; Query query =
		 * entityManager.createQuery(hql); List<Student> resultList =
		 * query.getResultList(); for(Student s: resultList) System.out.println(s);
		 */
//		for Searching Purpose value
		String hql = "Select e from Student e where e.age=?1";
		Query query = entityManager.createQuery(hql);
		Query setParameter = query.setParameter(1, 32);// searching we use setParameter(delimeter, searching value)
		List<Student> resultList = query.getResultList();
		for(Student s: resultList)
			System.out.println(s);
		
	}
}
