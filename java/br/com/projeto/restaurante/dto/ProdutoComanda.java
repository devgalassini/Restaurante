package br.com.projeto.restaurante.dto;

public class ProdutoComanda {
	private Integer id;
	private Integer quantidade;
	private ProdutoDTO produto;
	
	public ProdutoComanda(Integer id, Integer quantidade, ProdutoDTO produto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
