package br.com.projeto.restaurante.dto;

import java.util.List;

public class ComandaDTO {
	private Integer id;
	private Integer idCliente;
	private String status;
	private Float valorTotal;
	private List<ProdutoComanda> produtos;
	
	public ComandaDTO(Integer id, Integer idCliente, String status, Float valorTotal, List<ProdutoComanda> produtos) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.status = status;
		this.valorTotal = valorTotal;
		this.produtos = produtos;
	}
	
	public List<ProdutoComanda> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoComanda> produtos) {
		this.produtos = produtos;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
}
