package TESTES;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import model.Contato;
import utils.JPAUtils;

public class teste1 {
	public static void main(String[] args) {
		EntityManager em = JPAUtils.getEntityManager();

// Estado transiente
		Contato contato = new Contato(null, "Jusé", "35998935624", "jusezin@gmail.com", LocalDate.of(1990, 7, 25));

//insert
		em.getTransaction().begin();
		em.persist(contato); // Estado: Managed
		contato.setNome("José");
		em.getTransaction().commit();
		em.close();
// emf.close();
	}
}
