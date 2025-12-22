package ManyToOne;

import java.util.List;
import javax.persistence.*;

public class FetchValue {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Departmentee department = entityManager.find(Departmentee.class, "Software Developer");

		Query query = entityManager.createQuery("select e from Employee e where e.d = :dept");
		query.setParameter("dept", department);

		List<Employee> employees = query.getResultList();

		for (Employee e : employees) {
			System.out.println(e.getName());
		}
	}
}
