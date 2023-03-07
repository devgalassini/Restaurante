package br.com.projeto.restaurante.model;

public class ProdutoComandaEntity {

    private Integer id;
    private ProdutoEntity produto;
    private Integer idComanda;
    private Integer quantidade;
    
	public ProdutoComandaEntity(Integer id, ProdutoEntity produto, Integer idComanda, Integer quantidade) {
		super();
		this.id = id;
		this.produto = produto;
		this.idComanda = idComanda;
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProdutoEntity getproduto() {
		return produto;
	}

	public void setIdProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
    
}
