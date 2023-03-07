package br.com.projeto.restaurante.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.restaurante.dao.RepositoryDao;
import br.com.projeto.restaurante.dto.ProdutoDTO;
import br.com.projeto.restaurante.dto.parserModel.ProdutoModelParaDto;
import br.com.projeto.restaurante.enums.ServicesName;
import br.com.projeto.restaurante.model.ProdutoEntity;
import br.com.projeto.restaurante.service.Services;

@Service
public class ServiceProduto implements Services<ProdutoDTO>{
	
	@Autowired
	private RepositoryDao<ProdutoEntity> produtoDao;
	
	@Override
	public void salvar(ProdutoDTO entidade) {
		produtoDao.salvar(new ProdutoEntity(entidade.getNome(), entidade.getPreco(), null));	
	}

	@Override
	public List<ProdutoDTO> todos() {
		return ProdutoModelParaDto.modelParaDtoList(produtoDao.buscarTodos());
	}

	@Override
	public ProdutoDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutoDTO> findByEntityValues(ProdutoDTO entity) {
		return ProdutoModelParaDto.modelParaDtoList(produtoDao.buscarPorValores(
				new ProdutoEntity(entity.getNome(), 
						entity.getPreco(), 
						entity.getId())));
	}

	@Override
	public String serviceName() {
		return ServicesName.PRODUTO.toString();
	}

	@Override
	public void deleteRelacionamento(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
