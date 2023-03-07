package br.com.projeto.restaurante.model;

import com.google.gson.Gson;

public class ClienteEntity {
	private Integer id;
	private String name;
	private String email;

	public ClienteEntity(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public ClienteEntity(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Integer getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
