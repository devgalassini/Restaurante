package br.com.projeto.restaurante.service;

import java.util.List;

public interface Services<T> {
	void salvar(T entidade);
	
	List<T> todos();
	
	T findById(Integer id);
	
	List<T> findByEntityValues(T entity);
	
	String serviceName();
	
	void deleteRelacionamento(Integer id);
}
