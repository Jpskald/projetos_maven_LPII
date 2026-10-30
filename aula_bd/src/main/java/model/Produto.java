package model;

public class Produto {
	private Integer id;
	private String nome;
	private Double valor;
	private Integer quantidadeEstoque;

	public Produto() {
	}

	public Produto(String nome, Double valor, Integer quantidadeEstoque) {
		this.nome = nome;
		this.valor = valor;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Produto(Integer id, String nome, Double valor, Integer quantidadeEstoque) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.quantidadeEstoque = quantidadeEstoque;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Integer getQtde() {
		return quantidadeEstoque;
	}

	public void setQtde(Integer qtde) {
		this.quantidadeEstoque = qtde;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}
}
