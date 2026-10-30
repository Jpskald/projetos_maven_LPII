package TESTES;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class teste_conexao {
	public static void main(String[] args) {
		// carrega a unidade de persistência (persistence.xml)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meus_contatos");
		
		// estabelece conexão -> insert, uptade, select. delete
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Conectou!");
		
		em.close();
		emf.close();
	}
}
