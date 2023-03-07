package br.com.projeto.restaurante.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.projeto.restaurante.Exceptions.DaoExceptions;
import br.com.projeto.restaurante.enums.querys.SimpleQuerys;
import br.com.projeto.restaurante.model.ProdutoComandaEntity;
import br.com.projeto.restaurante.model.rowMappers.ProdutoComandaEntityRowMapper;

@Repository
public class RepositoryProdutoComandaEntity {
	
	@Autowired
	private JdbcTemplate connection;
	
	private static String PARAM_FULL_LOAD= "  c.ID as ID_COMANDA, pc.ID as ID_PC, pc.ID_PRODUTO, pc.QUANTIDADE, p.NOME, p.PRECO  ";
	
	private static String TABLE_FULL_LOAD= new StringBuilder()
			.append(" comanda c  ")
			.append(" INNER JOIN produto_comanda pc ON c.ID = pc.ID_COMANDA ")
			.append(" INNER JOIN produtos p ON p.ID = pc.ID_PRODUTO ")
			.toString();
	
	private static String VARIABLES = new StringBuilder()
			.append(" ID_PRODUTO, ")
			.append(" ID_COMANDA, ")
			.append(" QUANTIDADE ")
			.toString();

	
	private static String TABLE = " PRODUTO_COMANDA ";
	
	public List<ProdutoComandaEntity> buscarProdutoComandaEntityPeloIdDaComanda(Integer id) {
		String sql = SimpleQuerys.SIMPLE_SELECT_WITH_WHERE.getQuery()
				.replace("{param}", PARAM_FULL_LOAD)
				.replace("{table}", TABLE_FULL_LOAD)
				.replace("{cond}", "c.ID = "+id);
		try {
			return connection.query(sql, new ProdutoComandaEntityRowMapper());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}
	
	public void salvar(ProdutoComandaEntity entity) {
		String sql = SimpleQuerys.SIMPLE_INSERT.getQuery()
				.replace("{table}", TABLE)
				.replace("{variables}", VARIABLES)
				.replace("{values}", " "+entity.getproduto().getId() + " , " 
						+ entity.getIdComanda() + " , "
						+ entity.getQuantidade() + " ");
		try {
			int i = connection.update(sql);
			if(i < 1) throw new DaoExceptions("Erro a tentar inserir ProdutoComandaEntity : " + entity.toString());
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}
	
	public void deletar(Integer id) {
		String sql = SimpleQuerys.SIMPLE_DELETE_WITH_WHERE.getQuery()
				.replace("{table}", TABLE)
				.replace("{cond}", " id = "+ id);
		try {
			int i = connection.update(sql);
			if(i < 1) throw new DaoExceptions("Erro a tentar deletar Produto Comanda : " + id);
		} catch (Exception e) {
			throw new DaoExceptions(e.getMessage());
		}
	}
}
