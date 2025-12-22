package manyTomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchBasedOnStudentName {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String studentName = "Rahul";

		Query query = entityManager.createQuery("select s from Students s where s.name = :name");
		query.setParameter("name", studentName);

		Students student = (Students) query.getSingleResult();

		System.out.println("Courses for student: " + student.getName());
		for (Courses c : student.getCourse()) {
			System.out.println(c.getCname() + " | Fee: " + c.getFee());
		}
	}
}
