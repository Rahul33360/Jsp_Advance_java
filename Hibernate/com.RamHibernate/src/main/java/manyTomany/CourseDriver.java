package manyTomany;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CourseDriver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Students s1 = new Students();
		s1.setName("Rahul");
		s1.setId(1);
		Students s2 = new Students();
		s2.setName("A");
		s2.setId(2);
		Students s3 = new Students();
		s3.setName("B");
		s3.setId(3);
		Students s4 = new Students();
		s4.setName("C");
		s4.setId(4);
		Students s5 = new Students();
		s5.setName("D");
		s5.setId(5);

		Courses c1 = new Courses();
		c1.setCname("JavaScript");
		c1.setCId(21);
		c1.setFee(2000);
		Courses c2 = new Courses();
		c2.setCname("Java");
		c2.setCId(22);
		c2.setFee(1000);
		Courses c3 = new Courses();
		c3.setCname("ShellScript");
		c3.setCId(23);
		c3.setFee(3000);
		Courses c4 = new Courses();
		c4.setCname("DevOps");
		c4.setCId(24);
		c4.setFee(12000);
		Courses c5 = new Courses();
		c5.setCname("AWS");
		c5.setCId(25);
		c5.setFee(4000);
		Courses c6 = new Courses();
		c6.setCname("Spring");
		c6.setCId(26);
		c6.setFee(1400);

		entityManager.getTransaction().begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		entityManager.persist(s4);
		entityManager.persist(s5);

		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityManager.persist(c4);
		entityManager.persist(c5);
		entityManager.persist(c6);

		s1.setCourse(Arrays.asList(c1, c2, c3, c4, c5, c6));
		s2.setCourse(Arrays.asList(c1, c4, c5, c6));
		s3.setCourse(Arrays.asList(c4, c5, c6));
		s4.setCourse(Arrays.asList(c1, c2, c3));
		s5.setCourse(Arrays.asList(c1, c2, c3, c5, c6));

		entityManager.getTransaction().commit();

	}
}
