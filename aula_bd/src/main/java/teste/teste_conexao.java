package teste;

import java.sql.SQLException;

import dao.Conexao;

public class teste_conexao {
	public static void main(String[] args) {
		try {
			Conexao.getInstance();
			System.out.println("Conectou");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
