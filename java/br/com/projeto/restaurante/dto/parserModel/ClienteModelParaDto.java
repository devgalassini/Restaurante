package br.com.projeto.restaurante.dto.parserModel;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.restaurante.dto.ClienteDTO;
import br.com.projeto.restaurante.model.ClienteEntity;

public class ClienteModelParaDto {
	private ClienteModelParaDto() {}
	
	public static ClienteDTO modelParaDto(ClienteEntity entity) {
		ClienteDTO dto = new ClienteDTO(entity.getName(), entity.getEmail());
		dto.setId(entity.getId());
		return dto;
	}
	
	public static List<ClienteDTO> modelParaDtoList(List<ClienteEntity> entity) {
		List<ClienteDTO> list = new ArrayList<>();
		entity.stream().forEach(e -> list.add(modelParaDto(e)));
		return list;
	}
}
