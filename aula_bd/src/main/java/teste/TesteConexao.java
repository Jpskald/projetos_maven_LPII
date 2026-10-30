package teste;

import java.sql.SQLException;

import dao.Conexao;
public class TesteConexao {

	public static void main(String[] args) {
		try {
			Conexao.getInstance();
			System.out.println("Conectou.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
