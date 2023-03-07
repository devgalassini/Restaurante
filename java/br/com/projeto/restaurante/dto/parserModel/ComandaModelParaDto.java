package br.com.projeto.restaurante.dto.parserModel;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.restaurante.dto.ComandaDTO;
import br.com.projeto.restaurante.enums.StatusComanda;
import br.com.projeto.restaurante.model.ComandaEntity;

public class ComandaModelParaDto {
	private ComandaModelParaDto() {}
	
	public static ComandaEntity dtoParaModel(ComandaDTO dto) {
		return new ComandaEntity(dto.getId(), dto.getIdCliente(), StatusComanda.getByStatus(dto.getStatus()));
	}
	
	public static ComandaDTO modelParaDto(ComandaEntity entity) {
		return new ComandaDTO(entity.getId(), 
				entity.getClienteId(), 
				entity.getStatus().getStatus(), 
				null,
				null);
	}
	
	public static List<ComandaDTO> modelParaDtoList(List<ComandaEntity> entity) {
		List<ComandaDTO> list = new ArrayList<>();
		entity.stream().forEach(e -> list.add(modelParaDto(e)));
		return list;
	}
}
