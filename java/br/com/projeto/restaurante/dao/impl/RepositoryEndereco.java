package br.com.projeto.restaurante.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.projeto.restaurante.Exceptions.DaoExceptions;
import br.com.projeto.restaurante.enums.querys.SimpleQuerys;
import br.com.projeto.restaurante.model.EnderecoEntity;

@Repository
public class RepositoryEndereco {
	
	@Autowired
	private JdbcTemplate connection;
	
	private static String TABLE= " ENDERECO ";
	

	private static String VARIABLES = new StringBuilder()
			.append("ID_CLIENTE, ")
			.append("CEP, ")
			.append("ADDRESS, ")
			.append("STATE, ")
			.append("CITY ")
			.toString();
	
	public void salvar(EnderecoEntity entity){
		String values =  new StringBuilder()
				.append(" "+entity.getIdCliente()+", ")
				.append(" '"+entity.getCep()+"', ")
				.append(" '"+entity.getAddress()+"', ")
				.append(" '"+entity.getState()+"', ")
				.append(" '"+entity.getCity()+"' ")
				.toString();
		
		String sql = SimpleQuerys.SIMPLE_INSERT.getQuery()
				.replace("{table}", TABLE)
				.replace("{variables}", VARIABLES)
				.replace("{values}", values);
		try {
			int i = connection.update(sql);
			if(i < 1) throw new DaoExceptions("Erro a tentar inserir cliente : " + entity.toString());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
		
	}
}
