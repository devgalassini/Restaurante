package br.com.projeto.restaurante.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.projeto.restaurante.Exceptions.DaoExceptions;
import br.com.projeto.restaurante.dao.RepositoryDao;
import br.com.projeto.restaurante.enums.querys.SimpleQuerys;
import br.com.projeto.restaurante.model.ClienteEntity;
import br.com.projeto.restaurante.model.rowMappers.ClienteRowMapper;


@Repository
public class RepositoryCliente implements RepositoryDao<ClienteEntity>{
	
	@Autowired
	private JdbcTemplate connection;
		
	private static String VARIABLES = new StringBuilder()
			.append("NOME ,")
			.append("EMAIL ")
			.toString();
	
	private static String TABLE= " CLIENTE ";
	
	@Override
	public void salvar(ClienteEntity entity){
		String sql = SimpleQuerys.SIMPLE_INSERT.getQuery()
				.replace("{table}", TABLE)
				.replace("{variables}", VARIABLES)
				.replace("{values}", "'"+entity.getName() + "', '" +entity.getEmail()+"'");
		try {
			int i = connection.update(sql);
			if(i < 1) throw new DaoExceptions("Erro a tentar inserir cliente : " + entity.toString());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
		
	}

	@Override
	public List<ClienteEntity> buscarTodos() {
		String sql = SimpleQuerys.SIMPLE_SELECT.getQuery()
			.replace("{param}", " * ")
			.replace("{table}", TABLE);
		try {
			return connection.query(sql, new ClienteRowMapper());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}

	@Override
	public ClienteEntity buscarPorId(Integer id) {
		String sql = SimpleQuerys.SIMPLE_SELECT_WITH_WHERE.getQuery()
				.replace("{param}", " * ")
				.replace("{table}", TABLE)
				.replace("{cond}", " ID = "+id.toString());
		try {
			return connection.queryForObject(sql, new ClienteRowMapper());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}

	@Override
	public List<ClienteEntity> buscarPorValores(ClienteEntity entity) {
			try {
				String sql = SimpleQuerys.SIMPLE_SELECT_WITH_WHERE.getQuery()
						.replace("{param}", " * ")
						.replace("{table}", TABLE)
						.replace("{cond}", defineValoresParaBusca(entity));
				return connection.query(sql, new ClienteRowMapper());
			} catch (Exception e) {
				throw new DaoExceptions(e.getMessage());
			}
	}
	private String defineValoresParaBusca(ClienteEntity entity) throws Exception {
		String cond = "";
		cond = entity.getId() == null ? cond : "ID = " + entity.getId()+" AND ";
		cond = entity.getName() == null ? cond : cond + "NOME = '" + entity.getName()+"' AND ";
		cond = entity.getEmail() == null ? cond : cond + "EMAIL = '" + entity.getEmail()+"' AND ";
		if(cond.equals("")) throw new Exception("Variaveis de Busca invalidas");
		return cond.substring(0, cond.length()-4);
	}
}
