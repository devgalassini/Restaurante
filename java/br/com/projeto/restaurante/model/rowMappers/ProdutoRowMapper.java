package br.com.projeto.restaurante.model.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.projeto.restaurante.model.ProdutoEntity;

public class ProdutoRowMapper implements RowMapper<ProdutoEntity>{

	@Override
	public ProdutoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProdutoEntity(rs.getString("NOME"), 
				rs.getFloat("PRECO"), 
				rs.getInt("ID"));
	}
}