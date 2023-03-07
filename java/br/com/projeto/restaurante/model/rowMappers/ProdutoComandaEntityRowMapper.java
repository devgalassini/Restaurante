package br.com.projeto.restaurante.model.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.projeto.restaurante.model.ProdutoComandaEntity;
import br.com.projeto.restaurante.model.ProdutoEntity;

public class ProdutoComandaEntityRowMapper implements RowMapper<ProdutoComandaEntity>{

	@Override
	public ProdutoComandaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProdutoEntity produto = new ProdutoEntity(rs.getString("NOME"), 
				rs.getFloat("PRECO"), 
				rs.getInt("ID_PRODUTO"));
		return new ProdutoComandaEntity(rs.getInt("ID_PC"), 
				produto, 
				rs.getInt("ID_COMANDA"), 
				rs.getInt("QUANTIDADE"));
	}

}
