package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao;
	
	private String BANCO_DADOS = "aula_bd";
	private String LOGIN = "root";
	private String SENHA = "123456";
	
	private Conexao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/" + BANCO_DADOS;
		conexao = DriverManager.getConnection(url, LOGIN, SENHA);
		conexao.setAutoCommit(false);
	}
	
	public static Connection getInstance() throws ClassNotFoundException, SQLException {
		if (conexao == null || conexao.isClosed()) {
			new Conexao();
		}
		return conexao;
	}
}
