package br.com.projeto.restaurante.enums;

public enum StatusComanda {
	
	A("aberta"),
	F("fechada"),
	P("paga");

	private String status;
	
	private StatusComanda(String status) {
		this.status=status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public static StatusComanda getByStatus(String status) {
		for (StatusComanda s : StatusComanda.values()) {
			if(s.getStatus().equals(status)) return s;
		}
		return null;
	}
}
