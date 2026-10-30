package TESTES;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import model.Contato;
import utils.JPAUtils;

public class teste2 {
	public static void main(String[] args) {
		EntityManager em = JPAUtils.getEntityManager();
		
				
		// Estado: Detached
		Contato contato = new Contato(7, "Jose Antonio Pereira", "35712544", "jose3@gmail.com", LocalDate.of(2002, 8, 21));
		
		// update
		em.getTransaction().begin();
		contato = em.merge(contato); // Estado: Managed
		contato.setCelular("1111-1111");
		em.getTransaction().commit();
		
		em.close();
	}
}
