package br.com.projeto.restaurante.dto.parserModel;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.restaurante.dto.ProdutoComanda;
import br.com.projeto.restaurante.model.ProdutoComandaEntity;
import br.com.projeto.restaurante.model.ProdutoEntity;

public class ProdutoComandaModelParaDto {
	
	private ProdutoComandaModelParaDto() {}
	
	
	public static ProdutoComanda modelParaDto(ProdutoComandaEntity entity) {
		return new ProdutoComanda(entity.getId(), 
				entity.getQuantidade(), 
				ProdutoModelParaDto.modelParaDto(entity.getproduto()));
	}
	
	public static List<ProdutoComanda> modelParaDtoList(List<ProdutoComandaEntity> entity) {
		List<ProdutoComanda> list = new ArrayList<>();
		entity.stream().forEach(e -> list.add(modelParaDto(e)));
		return list;
	}
	
	public static ProdutoComandaEntity dtoParaEntity(Integer idComanda, ProdutoComanda produto) {
		return new ProdutoComandaEntity(produto.getId(), 
				new ProdutoEntity(produto.getProduto().getNome(), 
						produto.getProduto().getPreco(), 
						produto.getProduto().getId()), 
				idComanda, 
				produto.getQuantidade());
	}
	
	public static List<ProdutoComandaEntity> dtoParaEntityList(Integer idComanda, List<ProdutoComanda> produto) {
		List<ProdutoComandaEntity> list = new ArrayList<>();
		produto.stream().forEach(p -> list.add(dtoParaEntity(idComanda, p)));
		return list;
	}
}
