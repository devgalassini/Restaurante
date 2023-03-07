package br.com.projeto.restaurante.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.restaurante.dao.RepositoryDao;
import br.com.projeto.restaurante.dao.impl.RepositoryEndereco;
import br.com.projeto.restaurante.dto.ClienteDTO;
import br.com.projeto.restaurante.dto.parserModel.ClienteModelParaDto;
import br.com.projeto.restaurante.dto.parserModel.EnderecoModelParaDto;
import br.com.projeto.restaurante.enums.ServicesName;
import br.com.projeto.restaurante.model.ClienteEntity;
import br.com.projeto.restaurante.service.Services;

@Service
public class ServiceCliente implements Services<ClienteDTO>{
	
	@Autowired
	private RepositoryDao<ClienteEntity> clienteDao;
	
	@Autowired
	private RepositoryEndereco enderecoDao;
	
	@Override
	@Transactional
	public void salvar(ClienteDTO entidade) {
		clienteDao.salvar(new ClienteEntity(entidade.getNome(), entidade.getEmail()));
		List<ClienteDTO> cliente = findByEntityValues(entidade);
		if(!cliente.isEmpty())
			enderecoDao.salvar(EnderecoModelParaDto.dtoParaEntity(cliente.get(0).getId()
					, entidade.getEndereco()));
	}

	@Override
	public List<ClienteDTO> todos() {
		return ClienteModelParaDto.modelParaDtoList(clienteDao.buscarTodos());
	}
	
	@Override
	public ClienteDTO findById(Integer id) {
		return  ClienteModelParaDto.modelParaDto(clienteDao.buscarPorId(id));
	}
	
	@Override
	public String serviceName() {
		return ServicesName.CLIENTE.toString();
	}

	@Override
	public List<ClienteDTO> findByEntityValues(ClienteDTO entity) {
		return ClienteModelParaDto.modelParaDtoList(
				clienteDao.buscarPorValores(
						new ClienteEntity(entity.getNome(), entity.getEmail())));
	}

	@Override
	public void deleteRelacionamento(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
