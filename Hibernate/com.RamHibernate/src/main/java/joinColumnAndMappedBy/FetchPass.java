package joinColumnAndMappedBy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchPass {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Rahul");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Passport passport = entityManager.find(Passport.class, 42);

		Client client = passport.getClient();
		System.out.println(client.getName());

	}
}
