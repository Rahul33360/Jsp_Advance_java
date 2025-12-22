package ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpDriver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Departmentee d1 = new Departmentee();
		d1.setDid(1);
		d1.setDname("Software Developer");
//		
		Departmentee d2 = new Departmentee();
		d2.setDid(2);
		d2.setDname("AI/ML");
		
		
		Employee e1 = new Employee();
		e1.setName("Rahul");
		
		Employee e2 = new Employee();
		e2.setName("abcc");
		
		Employee e3 = new Employee();
		e3.setName("kr");
		
		Employee e4 = new Employee();
		e4.setName("aka");
		
		Employee e5 = new Employee();
		e5.setName("daa");
		
		e1.setD(d1);
		e2.setD(d1);
		e3.setD(d2);
		e4.setD(d2);
		e5.setD(d1);
		
		entityManager.getTransaction().begin();
		entityManager.persist(d1);
		entityManager.persist(d2);
		entityManager.persist(e1);
		entityManager.persist(e2);
		entityManager.persist(e3);
		entityManager.persist(e4);
		entityManager.persist(e5);
		
		entityManager.getTransaction().commit();
		
		
		
	}
}
