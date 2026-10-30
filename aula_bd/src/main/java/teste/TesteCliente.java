package teste;

import java.sql.SQLException;
import java.util.List;

import dao.ClienteDao;
import model.Cliente;

public class TesteCliente {

	public static void main(String[] args) {
		ClienteDao dao = new ClienteDao();

		try {
			Cliente novoCliente = new Cliente("Maria Oliveira", "123.456.789-00", "(35) 98888-1111", "maria@gmail.com");
			dao.cadastrar(novoCliente);
			System.out.println("Cliente cadastrado com sucesso!");

			List<Cliente> lista = dao.listar();
			Cliente ultimoCliente = null;
			for (Cliente c : lista) {
				System.out.println(c);
				ultimoCliente = c;
			}

			if (ultimoCliente != null) {
				ultimoCliente.setNome(ultimoCliente.getNome() + " Silva");
				ultimoCliente.setTelefone("(35) 99999-2222");
				dao.alterar(ultimoCliente);
				System.out.println("Cliente alterado com sucesso: " + dao.buscarPorId(ultimoCliente.getId()));

				dao.excluir(ultimoCliente.getId());
				System.out.println("Cliente ID " + ultimoCliente.getId() + " excluído com sucesso!");

				List<Cliente> listaFinal = dao.listar();
				System.out.println("Total de clientes restantes no banco: " + listaFinal.size());
			}



		} catch (ClassNotFoundException e) {
			System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erro de SQL: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
