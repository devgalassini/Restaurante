package br.com.projeto.restaurante.dao;

import java.util.List;

public interface RepositoryDao<T> {
	void salvar(T entity);
	
	List<T> buscarTodos();
	
	T buscarPorId(Integer id);
	
	List<T> buscarPorValores(T entity);
}
