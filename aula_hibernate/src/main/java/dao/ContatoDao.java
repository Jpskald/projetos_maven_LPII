package dao;

import java.time.LocalDate;
import java.util.List;

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
		em.persist(cont); //insert
		em.getTransaction().commit();
	}
	
	public void alterar(Contato cont)
	{
		em.getTransaction().begin();
		em.merge(cont); // update
		em.getTransaction().commit();
	}
	
	public void excluir(int id)
	{
		em.getTransaction().begin();
		Contato cont = em.find(Contato.class, id); //select
		em.remove(cont); //delete
		em.getTransaction().commit();
	}
	
	public Contato buscarPorId(int Id)
	{
		return em.find(Contato.class, Id);
	}
	
	public List <String> buscarPorNome(String nome)
	{
		String jpql = "SELECT c.nome FROM Contato c WHERE c.nome LIKE :param_nome";
		return em.createQuery(jpql, String.class).setParameter("param_nome", nome).getResultList();
	}
	public String buscarPorEmail(String nome)
	{
		String jpql = "SELECT c FROM Contato c WHERE c.email = :param_nome";
		return em.createQuery(jpql, String.class).setParameter("param_email", nome).getSingleResult();
	}
	
	public List<Contato> buscarTodos()
	{
		String jpql = "SELECT c FROM Contato c";
		return em.createQuery(jpql, Contato.class).getResultList();
	}

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao(JPAUtils.getEntityManager());
		//Contato contato = new Contato(null, "lucas", "1111-1122", "lucas@gmail.com", LocalDate.of(2002, 4, 10));
		//dao.cadastrar(contato); insert
		//Contato contato = new Contato(7, "lucas", "1111-1122", "lucasalgumacoisa@gmail.com", LocalDate.of(2002, 4, 10));
		//dao.alterar(contato); // update
		//dao.excluir(7);
		
		//Contato c = dao.buscarPorId(1);
		//System.out.println(c.toString());
		//List<Contato> lista = dao.buscarTodos();
		List<String> lista = dao.buscarPorNome("%se%");
		System.out.println(lista);
		System.out.println("----------------");
		String email = dao.buscarPorEmail("maria@gmail.com");
		System.out.println(email);
	}
}
