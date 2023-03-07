package br.com.projeto.restaurante.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.restaurante.dao.RepositoryDao;
import br.com.projeto.restaurante.dao.impl.RepositoryProdutoComandaEntity;
import br.com.projeto.restaurante.dto.ComandaDTO;
import br.com.projeto.restaurante.dto.parserModel.ComandaModelParaDto;
import br.com.projeto.restaurante.dto.parserModel.ProdutoComandaModelParaDto;
import br.com.projeto.restaurante.enums.ServicesName;
import br.com.projeto.restaurante.model.ComandaEntity;
import br.com.projeto.restaurante.service.Services;

@Service
public class ServiceComanda implements Services<ComandaDTO>{
	
	@Autowired
	private RepositoryDao<ComandaEntity> comandaDao;
	
	@Autowired
	private RepositoryProdutoComandaEntity produtoComanda;
	
	@Override
	public void salvar(ComandaDTO entidade) {
		if(entidade.getId() == null && entidade.getProdutos() == null) {
			comandaDao.salvar(ComandaModelParaDto.dtoParaModel(entidade));
		}else{
			ProdutoComandaModelParaDto.dtoParaEntityList(entidade.getId(), entidade.getProdutos())
				.stream().forEach(p -> {if(p.getQuantidade() > 0) produtoComanda.salvar(p);});
		}
	}

	@Override
	public List<ComandaDTO> todos() {
		return ComandaModelParaDto.modelParaDtoList(comandaDao.buscarTodos());
	}


	@Override
	public ComandaDTO findById(Integer id) {
		ComandaDTO comanda = ComandaModelParaDto.modelParaDto(comandaDao.buscarPorId(id));
		comanda.setProdutos(ProdutoComandaModelParaDto
				.modelParaDtoList(produtoComanda
						.buscarProdutoComandaEntityPeloIdDaComanda(id)));
		return comanda;
	}

	@Override
	public String serviceName() {
		return ServicesName.COMANDA.toString();
	}

	@Override
	public List<ComandaDTO> findByEntityValues(ComandaDTO entity) {
		List<ComandaDTO> comandas = ComandaModelParaDto.modelParaDtoList(
				comandaDao.buscarPorValores(
						ComandaModelParaDto.dtoParaModel(entity)));
		comandas.forEach(c -> somaValorComanda(c));
		return comandas;
	}
	
	private void somaValorComanda(ComandaDTO comanda) {
		comanda.setProdutos(
				ProdutoComandaModelParaDto.modelParaDtoList(
						produtoComanda.buscarProdutoComandaEntityPeloIdDaComanda(comanda.getId())));
		comanda.setValorTotal(0F);
		comanda.getProdutos().stream()
			.forEach(p -> comanda
					.setValorTotal(comanda.getValorTotal() +  (p.getProduto().getPreco() * p.getQuantidade())));
	}

	@Override
	public void deleteRelacionamento(Integer id) {
		produtoComanda.deletar(id);
	}
}
