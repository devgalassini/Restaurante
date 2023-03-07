package br.com.projeto.restaurante.dto;

public class ProdutoDTO {
	private Integer id;
	private String nome;
	private Float preco;
	
	public ProdutoDTO(Integer id, String nome, Float preco) {
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
