package dao;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import model.Contato;
import model.Produto;
import utils.JPAUtils;

public class ProdutoDao {
	private EntityManager em;
	
	public ProdutoDao(EntityManager em)
	{
		this.em = em;
	}
	public void cadastrar(Produto prod)
	{
		em.getTransaction().begin();
		em.persist(prod);
		em.getTransaction().commit();
	}
	
	public void alterar(Produto prod)
	{
		em.getTransaction().begin();
		em.merge(prod);
		em.getTransaction().commit();
	}
	
	public void excluir(int id)
	{
		em.getTransaction().begin();
		Produto prod = em.find(Produto.class, id);
		em.remove(prod);
		em.getTransaction().commit();
	}
	
	public Produto buscaPorId(int id)
	{
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscaContato()
	{
		String jpql = "SELECT p FROM produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public static void main(String[] args) {
		ProdutoDao dao = new ProdutoDao(JPAUtils.getEntityManager());
		Produto produto = new Produto(null, "pão", 5.00, 10);

		
		dao.cadastrar(produto);
}}
