package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// Apagar o getter, setter, allargsconstructor e noargsconstructor e fazer os métodos padrão caso não tenha o lombok (ou se em uma máquina não configurada
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "contatos")
public class Contato {
	@Id // gera chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // gera chaves automaticamente
	private Integer id;
	private String nome;
	private String celular;

	@Column(unique = true)
	private String email;

	@Column(name = "data_nasc")
	private LocalDate dataNascimento;

}