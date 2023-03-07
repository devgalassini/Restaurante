package br.com.projeto.restaurante.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.projeto.restaurante.Exceptions.DaoExceptions;
import br.com.projeto.restaurante.dao.RepositoryDao;
import br.com.projeto.restaurante.enums.querys.SimpleQuerys;
import br.com.projeto.restaurante.model.ComandaEntity;
import br.com.projeto.restaurante.model.rowMappers.ComandaRowMapper;

@Repository
public class RepositoryComanda  implements RepositoryDao<ComandaEntity>{
	
	@Autowired
	private JdbcTemplate connection;
	
	private static String VARIABLES = new StringBuilder()
			.append("ID_CLIENTE, ")
			.append("STATUS_COMANDA ")
			.toString();
	
	private static String TABLE= " COMANDA ";
	
	@Override
	public void salvar(ComandaEntity entity){
		String sql = SimpleQuerys.SIMPLE_INSERT.getQuery()
				.replace("{table}", TABLE)
				.replace("{variables}", VARIABLES)
				.replace("{values}", "'"+entity.getClienteId() + "', '" +entity.getStatus()+"'");
		try {
			int i = connection.update(sql);
			if(i < 1) throw new DaoExceptions("Erro a tentar inserir cliente : " + entity.toString());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
		
	}

	@Override
	public List<ComandaEntity> buscarTodos() {
		String sql = SimpleQuerys.SIMPLE_SELECT.getQuery()
				.replace("{param}", " * ")
				.replace("{table}", TABLE);
		try {
			return connection.query(sql, new ComandaRowMapper());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}

	@Override
	public ComandaEntity buscarPorId(Integer id) {
		String sql = SimpleQuerys.SIMPLE_SELECT_WITH_WHERE.getQuery()
				.replace("{param}", " * ")
				.replace("{table}", TABLE)
				.replace("{cond}", " ID = "+id.toString());
		try {
			return connection.queryForObject(sql, new ComandaRowMapper());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}

	@Override
	public List<ComandaEntity> buscarPorValores(ComandaEntity entity) {
		
		try {
			String sql = SimpleQuerys.SIMPLE_SELECT_WITH_WHERE.getQuery()
					.replace("{param}", " * ")
					.replace("{table}", TABLE)
					.replace("{cond}", defineValoresParaBusca(entity));
			List<ComandaEntity> r = connection.query(sql, new ComandaRowMapper());
			return r;
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}
	
	private String defineValoresParaBusca(ComandaEntity entity) throws Exception {
		String cond = "";
		cond = entity.getId() == null ? cond : "ID = " + entity.getId()+" AND ";
		cond = entity.getClienteId() == null ? cond : cond + "ID_CLIENTE = " + entity.getClienteId()+" AND ";
		cond = entity.getStatus() == null ? cond : cond + "STATUS_COMANDA = '" + entity.getStatus().toString()+"' AND ";
		if(cond.equals("")) throw new Exception("Variaveis de Busca invalidas");
		return cond.substring(0, cond.length()-4);
	}

}
