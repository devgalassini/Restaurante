package br.com.projeto.restaurante.dto.parserModel;

import br.com.projeto.restaurante.dto.EnderecoDTO;
import br.com.projeto.restaurante.model.EnderecoEntity;

public class EnderecoModelParaDto {
	private EnderecoModelParaDto() {}
	
	public static EnderecoEntity dtoParaEntity(Integer idCliente, EnderecoDTO end) {
		return new EnderecoEntity(null, 
				idCliente, 
				end.getCep(), 
				end.getAddress(), 
				end.getState(), 
				end.getDistrict(), 
				end.getCity());
	}
}
