package teste;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.ContatoDao;
import model.Contato;

public class TesteContato {

	public static void main(String[] args){
		ContatoDao dao = new ContatoDao();
		
		LocalDate data = LocalDate.of(2001, 10, 15);
		Contato cont = new Contato(13, "joao", "99999-9999", "joao@gmail.com", data);
		
		try {
			dao.excluir(12);
			System.out.println("Operacao realizada.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			List<Contato> lista = dao.listar();
			for(Contato c: lista) {
				System.out.println(c.toString());
			}
			
			System.out.println("Operacao realizada.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
