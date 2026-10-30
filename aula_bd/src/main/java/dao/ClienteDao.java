package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Cliente;

public class ClienteDao {

	public void cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO cliente (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cliente.getNome());
		comandoSql.setString(2, cliente.getCpf());
		comandoSql.setString(3, cliente.getTelefone());
		comandoSql.setString(4, cliente.getEmail());

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void alterar(Cliente cliente) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cliente.getNome());
		comandoSql.setString(2, cliente.getCpf());
		comandoSql.setString(3, cliente.getTelefone());
		comandoSql.setString(4, cliente.getEmail());
		comandoSql.setInt(5, cliente.getId());

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void excluir(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM cliente WHERE id = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public List<Cliente> listar() throws ClassNotFoundException, SQLException {
		List<Cliente> lista = new LinkedList<>();
		String sql = "SELECT * FROM cliente";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);

		ResultSet rs = comandoSql.executeQuery();

		while (rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setTelefone(rs.getString("telefone"));
			c.setEmail(rs.getString("email"));

			lista.add(c);
		}
		return lista;
	}

	public Cliente buscarPorId(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM cliente WHERE id = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setTelefone(rs.getString("telefone"));
			c.setEmail(rs.getString("email"));
			return c;
		}
		return null;
	}
}
