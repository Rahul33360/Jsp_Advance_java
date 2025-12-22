package joinColumnAndMappedBy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PassportDriver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Client c = new Client();
		c.setName("Rahul");

		Passport p = new Passport();
		p.setCountry("Australia");

		c.setPassport(p);
		p.setClient(c);

		entityManager.getTransaction().begin();
		entityManager.persist(c);
		entityManager.persist(p);
		entityManager.getTransaction().commit();

	}
}
