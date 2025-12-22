package manyTomany;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchStudentsByCourse {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String courseName = "AWS";

		Courses course = entityManager.find(Courses.class, courseName);

		Query query = entityManager.createQuery("select s from Students s where :course member of s.course");
		query.setParameter("course", course);

		List<Students> students = query.getResultList();

		System.out.println("Students enrolled in " + courseName + ":");
		for (Students s : students) {
			System.out.println(s.getName());
		}
	}
}
