package br.com.projeto.restaurante.Exceptions;

public class DaoExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DaoExceptions(String error) {
		super(error);
	}
}
