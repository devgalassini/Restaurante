package br.com.projeto.restaurante.enums.querys;

public enum SimpleQuerys {
	SIMPLE_INSERT("INSERT INTO {table} ({variables}) VALUES ({values})"),
	SIMPLE_SELECT("SELECT {param} FROM {table}"),
	SIMPLE_SELECT_WITH_WHERE("SELECT {param} FROM {table} WHERE {cond}"),
	SIMPLE_DELETE_WITH_WHERE("DELETE FROM {table} WHERE {cond}");
	
	private String query;
	
	private SimpleQuerys(String query) {
		this.query = query;
	}
	
	public String getQuery() {
		return this.query;
	}
}
