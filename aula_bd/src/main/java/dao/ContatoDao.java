package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Contato;

public class ContatoDao {

	public void cadastrar(Contato cont) throws ClassNotFoundException, SQLException {
		String sql = "insert into contato (nome_contato, cel_contato, email_contato, "
				+ "data_nasc_contato) values (?, ?, ?, ?)";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cont.getNome());
		comandoSql.setString(2, cont.getCelular());
		comandoSql.setString(3, cont.getEmail());
		
		Date data = cont.getDataNascimento() != null ? Date.valueOf(cont.getDataNascimento()) : null;
		comandoSql.setDate(4, data);
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public void alterar(Contato cont) throws ClassNotFoundException, SQLException {
		String sql = "update contato set "
				+ "nome_contato = ?, cel_contato = ?, email_contato = ?, "
				+ "data_nasc_contato = ? "
				+ "where id_contato = ?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, cont.getNome());
		comandoSql.setString(2, cont.getCelular());
		comandoSql.setString(3, cont.getEmail());
		
		Date data = cont.getDataNascimento() != null ? Date.valueOf(cont.getDataNascimento()) : null;
		comandoSql.setDate(4, data);
		comandoSql.setInt(5, cont.getId());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void excluir(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from contato where id_contato = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		        
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public List<Contato> listar() throws ClassNotFoundException, SQLException {
		List<Contato> lista = new LinkedList<>();
		String sql = "SELECT * FROM contato";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Contato c = new Contato();
			c.setId(rs.getInt("id_contato"));
			c.setNome(rs.getString("nome_contato"));
			c.setCelular(rs.getString("cel_contato"));
			c.setEmail(rs.getString("email_contato"));
			Date d = rs.getDate("data_nasc_contato");
			if (d != null) {
				c.setDataNascimento(d.toLocalDate());
			}
			lista.add(c);
		}
		return lista;
	}

	public Contato buscarPorId(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM contato WHERE id_contato = ?";
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		ResultSet rs = comandoSql.executeQuery();
		if (rs.next()) {
			Contato c = new Contato();
			c.setId(rs.getInt("id_contato"));
			c.setNome(rs.getString("nome_contato"));
			c.setCelular(rs.getString("cel_contato"));
			c.setEmail(rs.getString("email_contato"));
			Date d = rs.getDate("data_nasc_contato");
			if (d != null) {
				c.setDataNascimento(d.toLocalDate());
			}
			return c;
		}
		return null;
	}
}
