package model;

import java.time.LocalDate;

public class Contato {
	private Integer id;
	private String nome;
	private String celular;
	private String email;
	private LocalDate dataNascimento;

	public Contato() {
	}

	public Contato(String nome, String celular, String email, LocalDate dataNascimento) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Contato(Integer id, String nome, String celular, String email, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", celular=" + celular + ", email=" + email
				+ ", dataNascimento=" + dataNascimento + "]";
	}
}
