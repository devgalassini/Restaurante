package br.com.projeto.restaurante.connections;

public interface RepositorioCep<T> {
	T getCepData(String cep);
}
