package br.com.projeto.restaurante.model.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.projeto.restaurante.model.ClienteEntity;

public class ClienteRowMapper implements RowMapper<ClienteEntity>{

	@Override
	public ClienteEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClienteEntity cli = new ClienteEntity(rs.getInt("ID"),
				rs.getString("NOME"),
				rs.getString("EMAIL"));
		return cli;
	}

}
