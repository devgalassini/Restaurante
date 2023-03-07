package br.com.projeto.restaurante.model;

public class ProdutoEntity {
	private Integer id;
	private String nome;
	private Float preco;
	
	public ProdutoEntity(String nome, Float preco, Integer id) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
