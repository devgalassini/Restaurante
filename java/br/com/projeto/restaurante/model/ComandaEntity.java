package br.com.projeto.restaurante.model;

import br.com.projeto.restaurante.enums.StatusComanda;

public class ComandaEntity {
	private Integer id;
	private Integer clienteId;
	private StatusComanda status;
	
	public ComandaEntity(Integer id, Integer clienteId, StatusComanda status) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	public StatusComanda getStatus() {
		return status;
	}
	public void setStatus(StatusComanda status) {
		this.status = status;
	}
	
	
}
