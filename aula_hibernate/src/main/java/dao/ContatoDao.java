package dao;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import model.Contato;
import utils.JPAUtils;

public class ContatoDao {
	private EntityManager em; //conexao
	
	public ContatoDao(EntityManager em)
	{
		this.em = em;
	}
	
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
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao(JPAUtils.getEntityManager());
		Contato contato = new Contato(7, "zezin", "1111-1112", "zezin@gmail.com", LocalDate.of(2004, 7, 17));

		
		dao.cadastrar(contato);
	}
}
