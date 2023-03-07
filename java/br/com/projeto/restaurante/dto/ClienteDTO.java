package br.com.projeto.restaurante.dto;

import com.google.gson.Gson;

public class ClienteDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private EnderecoDTO endereco;
	
	public ClienteDTO(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
