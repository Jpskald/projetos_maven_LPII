package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Produto;

public class ProdutoDao {

	public void cadastrar(Produto prod) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO produto (nome, valor, quantidade_estoque) VALUES (?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, prod.getNome());
		comandoSql.setDouble(2, prod.getValor());
		comandoSql.setInt(3, prod.getQuantidadeEstoque());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public void alterar(Produto prod) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE produto SET nome = ?, valor = ?, quantidade_estoque = ? WHERE id = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, prod.getNome());
		comandoSql.setDouble(2, prod.getValor());
		comandoSql.setInt(3, prod.getQuantidadeEstoque());
		comandoSql.setInt(4, prod.getId());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	} 
	
	public void excluir(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM produto WHERE id = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
				        
		comandoSql.execute();
		Conexao.getInstance().commit();
	} 

	public List<Produto> listar() throws ClassNotFoundException, SQLException {
		List<Produto> lista = new LinkedList<>();
		String sql = "SELECT * FROM produto";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setValor(rs.getDouble("valor"));
			p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
			
			lista.add(p);
		}
		return lista;
	}

	public Produto buscarPorId(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM produto WHERE id = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setValor(rs.getDouble("valor"));
			p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
			return p;
		}
		return null;
	}
}