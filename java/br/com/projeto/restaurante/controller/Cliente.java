package br.com.projeto.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.restaurante.connections.RepositorioCep;
import br.com.projeto.restaurante.dto.ClienteDTO;
import br.com.projeto.restaurante.dto.EnderecoDTO;
import br.com.projeto.restaurante.service.Services;

@RestController
@RequestMapping(path = "/api/cliente")
public class Cliente {
	
	@Autowired
	private Services<ClienteDTO> service;
	
	@Autowired
	private RepositorioCep<EnderecoDTO> cepService;
	
	@PostMapping("")
	public ResponseEntity<String> saveClient(@RequestBody ClienteDTO dao){
		try {
			service.salvar(dao);
			return ResponseEntity.ok("{\"resp\":\"Cliente Salvo\"}");
		} catch (Exception e) {
			return new ResponseEntity<String>("Falha ao salva cliente", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<EnderecoDTO> saveClient(@PathVariable String cep){
		return ResponseEntity.ok(cepService.getCepData(cep));
	}
}
