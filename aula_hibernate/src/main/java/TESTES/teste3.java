package TESTES;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Contato;
import utils.JPAUtils;

public class teste3 {
	public static void main(String[] args) {
		EntityManager em = JPAUtils.getEntityManager();
	
		// Estado: Detached
		Contato contato = new Contato(7, "Jose Antonio Pereira", "1111-1111", "jose3@gmail.com", LocalDate.of(2002, 8, 21));
		
		// update
		em.getTransaction().begin();
		//contato = em.merge(contato); // Estado: Managed
		contato = em.find(Contato.class, contato.getId()); //Estado: Managed
		em.remove(contato); // Estado: Remove
		em.getTransaction().commit();
		
		em.close();
	}
}
