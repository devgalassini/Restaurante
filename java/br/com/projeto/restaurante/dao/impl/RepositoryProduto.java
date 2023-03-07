package br.com.projeto.restaurante.dao.impl;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.projeto.restaurante.Exceptions.DaoExceptions;
import br.com.projeto.restaurante.dao.RepositoryDao;
import br.com.projeto.restaurante.enums.querys.SimpleQuerys;
import br.com.projeto.restaurante.model.ProdutoEntity;
import br.com.projeto.restaurante.model.rowMappers.ProdutoRowMapper;

@Repository
public class RepositoryProduto implements RepositoryDao<ProdutoEntity>{

	@Autowired
	private JdbcTemplate connection;
	
	private static String VARIABLES = new StringBuilder()
			.append("NOME, ")
			.append("PRECO ")
			.toString();
	
	private static String TABLE= " PRODUTOS ";
	
	
	@Override
	public void salvar(ProdutoEntity entity) {
		String sql = SimpleQuerys.SIMPLE_INSERT.getQuery()
				.replace("{table}", TABLE)
				.replace("{variables}", VARIABLES)
				.replace("{values}", "'"+entity.getNome() + "', " + parsePreco(entity.getPreco()));
		try {
			int i = connection.update(sql);
			if(i < 1) throw new DaoExceptions("Erro a tentar inserir cliente : " + entity.toString());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
		
	}
	
	private String parsePreco(Float preco) {
		return new DecimalFormat("#.00")
				.format(preco).replace(",", ".");
	}

	@Override
	public List<ProdutoEntity> buscarTodos() {
		String sql = SimpleQuerys.SIMPLE_SELECT.getQuery()
				.replace("{param}", " * ")
				.replace("{table}", TABLE);
		try {
			return connection.query(sql, new ProdutoRowMapper());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}

	@Override
	public ProdutoEntity buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutoEntity> buscarPorValores(ProdutoEntity entity) {
		try {
			String sql = SimpleQuerys.SIMPLE_SELECT_WITH_WHERE.getQuery()
					.replace("{param}", " * ")
					.replace("{table}", TABLE)
					.replace("{cond}", defineValoresParaBusca(entity));
			return connection.query(sql, new ProdutoRowMapper());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}
	
	private String defineValoresParaBusca(ProdutoEntity entity) throws Exception {
		String cond = "";
		cond = entity.getId() == null ? cond : "ID = " + entity.getId()+" AND ";
		cond = entity.getNome() == null ? cond : cond + " NOME LIKE '%" + entity.getNome()+"%' AND ";
		cond = entity.getPreco() == null ? cond : cond + " PRECO = " + entity.getPreco().toString()+" AND ";
		if(cond.equals("")) throw new Exception("Variaveis de Busca invalidas");
		return cond.substring(0, cond.length()-4);
	}

}
