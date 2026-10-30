package dao;

import jakarta.persistence.EntityManager;
import model.Contato;

public class ContatoDao {
	private EntityManager em; //conexao
	
	public void cadastrar(Contato cont)
	{
		em.getTransaction().begin();
		em.persist(cont);
		em.getTransaction().commit();
	}
	
	public void alterar(Contato cont)
	{
		em.getTransaction().begin();
		em.merge(cont);
		em.getTransaction().commit();
	}
	
	public void excluir(int id)
	{
		em.getTransaction().begin();
		Contato cont = em.find(Contato.class, id);
		em.remove(cont);
		em.getTransaction().commit();
	}
}
