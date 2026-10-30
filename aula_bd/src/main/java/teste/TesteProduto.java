package teste;

import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDao;
import model.Produto;

public class TesteProduto {

	public static void main(String[] args) {
		ProdutoDao dao = new ProdutoDao();

		try {
			Produto novoProduto = new Produto("Monitor Gamer 24pol", 899.90, 8);
			dao.cadastrar(novoProduto);
			System.out.println("Produto cadastrado com sucesso!");

			List<Produto> lista = dao.listar();
			for (Produto p : lista) {
				System.out.println(p);
			}

			if (!lista.isEmpty()) {
				Produto p = lista.get(lista.size() - 1);

				p.setNome("Monitor Gamer 27pol");
				p.setValor(1199.00);
				p.setQuantidadeEstoque(12);
				dao.alterar(p);
				System.out.println("Produto alterado: " + dao.buscarPorId(p.getId()));

				dao.excluir(p.getId());
				System.out.println("Produto excluido com sucesso!");

				List<Produto> listaFinal = dao.listar();
				for (Produto item : listaFinal) {
					System.out.println(item);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
