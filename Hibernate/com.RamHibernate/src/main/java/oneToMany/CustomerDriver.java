package oneToMany;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerDriver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Customer c = new Customer();
		c.setName("Rahul");
		
		Product p1 = new Product();
		p1.setProductName("mobile");
		Product p2 = new Product();
		p2.setProductName("lappi");
		Product p3 = new Product();
		p3.setProductName("desktop");
		Product p4 = new Product();
		p4.setProductName("charger");
		Product p5 = new Product();
		p5.setProductName("mac");
		
		c.setP(Arrays.asList(p1,p2,p3,p4,p5));
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(c);
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityManager.persist(p4);
		entityManager.persist(p5);
		entityManager.getTransaction().commit();
	}
}
