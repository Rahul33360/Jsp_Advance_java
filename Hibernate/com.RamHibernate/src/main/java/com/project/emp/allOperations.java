package com.project.emp;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class allOperations {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	private static EntityTransaction transaction = entityManager.getTransaction();
	private static Scanner sc = new Scanner(System.in);
//	private static int id = 1;

	public static void insert() {
		emp e = new emp();

		System.out.print("Enter The Id ");
		e.setId(sc.nextInt());

		System.out.print("Enter Your First Name ");
		String name = sc.next();
	    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		e.setName(name);	
		
		System.out.print("Enter Your Age ");
		e.setAge(sc.nextInt());

		System.out.print("Enter Your Mobile No. ");
		e.setMobile(sc.next());

		System.out.print("Enter Your Email ");
		e.setEmail(sc.next());

		System.out.print("Enter Your Gender ");
		e.setGender(sc.next().toUpperCase().charAt(0));
		

		System.out.print("Enter The Marks ");
		e.setMarks(sc.nextInt());
		
		/*
		 * System.out.print("Enter The Grade ");
		 * e.setGrade(sc.next().toUpperCase().charAt(0));
		 */

		transaction.begin();
		entityManager.persist(e);
		transaction.commit();

	}

	public static void fetchById() {
		System.out.print("Enter The Id ");
		int idFetch = sc.nextInt();
		String hql = "Select e from emp e where e.id=?1";
		Query query = entityManager.createQuery(hql);
		Query setParameter = query.setParameter(1, idFetch);
		List<emp> resultList = query.getResultList();
		for (emp s : resultList)
			System.out.println(s.toString());
	}

	public static void fetchByName() {
		System.out.print("Enter The Name ");
		String nameFetch = sc.next();
		String hql = "Select e from emp e where e.name=?1";
		Query query = entityManager.createQuery(hql);
		Query setParameter = query.setParameter(1, nameFetch);
		List<emp> resultList = query.getResultList();
		for (emp s : resultList)
			System.out.println(s.toString());
	}

	public static void fetchFemaleEmp() {
		System.out.print("Here Are the Female Employee Only. ");
		char ch = 'F';
		String hql = "Select e from emp e where e.gender=?1";
		Query query = entityManager.createQuery(hql);
		Query setParameter = query.setParameter(1, ch);
		List<emp> resultList = query.getResultList();
		for (emp s : resultList)
			System.out.println(s.toString());
	}

	public static void fetchMaleEmp() {
		System.out.print("Here Are the Male Employee Only. ");
		char ch = 'M';
		String hql = "Select e from emp e where e.gender=?1";
		Query query = entityManager.createQuery(hql);
		Query setParameter = query.setParameter(1, ch);
		List<emp> resultList = query.getResultList();
		for (emp s : resultList)
			System.out.println(s.toString());
	}

	public static void fetchAll() {
		System.out.print("Here Is The All Details Of Employee");
		String hql = "Select e from emp e";
		Query query = entityManager.createQuery(hql);
		List<emp> resultList = query.getResultList();
		for (emp s : resultList)
			System.out.println(s.toString());
	}

	public static void fetchByGrade() {
	    System.out.print("Enter Grade (O/A/B/C/D/E/F): ");
	    char ch = sc.next().toUpperCase().charAt(0);
	    int min = 0, max = 0;
	    switch (ch) {
	        case 'O': min = 91; max = 100; break;
	        case 'A': min = 81; max = 90;  break;
	        case 'B': min = 71; max = 80;  break;
	        case 'C': min = 61; max = 70;  break;
	        case 'D': min = 51; max = 60;  break;
	        case 'E': min = 41; max = 50;  break;
	        case 'F': min = 0;  max = 40;  break;
	        default:
	            System.out.println("Invalid Grade!");
	            return;
	    }

	    String hql = "SELECT e FROM emp e WHERE e.marks BETWEEN :min AND :max";
	    Query query = entityManager.createQuery(hql);
	    query.setParameter("min", min);
	    query.setParameter("max", max);

	    List<emp> resultList = query.getResultList();

	    for (emp s : resultList)
	        System.out.println(s.toString());
	}

	public static void updateEmpById() {
		System.out.print("Enter the Id To Update Details ");
		int id = sc.nextInt();
		emp e = entityManager.find(emp.class, id);
//		entityManager.close();
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		entityManager2.getTransaction().begin();
		emp e2 = entityManager2.merge(e);
		System.out.print("Enter The New Name ");
		String name = sc.next();
	    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		e2.setName(name);
		entityManager2.getTransaction().commit();
	}

	public static void removeById() {
		System.out.print("Enter the Id To Remove Details ");
		int id = sc.nextInt();
		emp e = entityManager.find(emp.class, id);
		entityManager.remove(e);
		transaction.begin();
		transaction.commit();
	}

}
