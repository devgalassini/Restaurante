package br.com.projeto.restaurante.dto.parserModel;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.restaurante.dto.ProdutoDTO;
import br.com.projeto.restaurante.model.ProdutoEntity;

public class ProdutoModelParaDto {
	
	public static ProdutoDTO modelParaDto(ProdutoEntity entity) {
		return new ProdutoDTO(entity.getId(), 
				entity.getNome(), 
				entity.getPreco());
	}
	
	public static List<ProdutoDTO> modelParaDtoList(List<ProdutoEntity> entity) {
		List<ProdutoDTO> list = new ArrayList<>();
		entity.stream().forEach(e -> list.add(modelParaDto(e)));
		return list;
	}
}
