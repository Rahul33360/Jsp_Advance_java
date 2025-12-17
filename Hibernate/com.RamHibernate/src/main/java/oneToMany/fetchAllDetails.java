package oneToMany;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class fetchAllDetails {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Customer customer = entityManager.find(Customer.class, 10);
		
		List<Product> products = customer.getP();

		System.out.println(customer.getName() + "\t" + customer.getId());

		for (Product p : products) {
			System.out.println(p.getProductName() + "\t" + p.getId());
		}
	}
}
