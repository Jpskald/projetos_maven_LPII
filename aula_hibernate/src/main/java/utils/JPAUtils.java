package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {

	// constante
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("meus_contatos");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
