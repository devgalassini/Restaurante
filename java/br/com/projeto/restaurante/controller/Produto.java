package br.com.projeto.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.restaurante.dto.ProdutoDTO;
import br.com.projeto.restaurante.service.Services;

@RestController
@RequestMapping(path = "/api/produto")
public class Produto {
	@Autowired
	private Services<ProdutoDTO> service;
	
	@PostMapping("")
	public ResponseEntity<String> saveProduto(@RequestBody ProdutoDTO dao){
		try {
			service.salvar(dao);
			return ResponseEntity.ok("{\"resp\":\"Produto Salvo\"}");
		} catch (Exception e) {
			return new ResponseEntity<String>("Falha ao salvar produto", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("")
	public ResponseEntity<List<ProdutoDTO>> getProduto(@RequestParam(required=false) Integer id, @RequestParam(required=false) String nome){
		ProdutoDTO dto = new ProdutoDTO(id, 
				nome == "" ? null : nome, 
				null);
		return ResponseEntity.ok(service.findByEntityValues(dto));	
	}
}
