package br.com.projeto.restaurante.model.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.projeto.restaurante.enums.StatusComanda;
import br.com.projeto.restaurante.model.ComandaEntity;

public class ComandaRowMapper implements RowMapper<ComandaEntity>{

	@Override
	public ComandaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ComandaEntity(rs.getInt("ID"), 
				rs.getInt("ID_CLIENTE"), 
				StatusComanda.valueOf(rs.getString("STATUS_COMANDA")));
	}

}
