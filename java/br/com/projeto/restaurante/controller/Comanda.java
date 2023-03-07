package br.com.projeto.restaurante.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.restaurante.dto.ComandaDTO;
import br.com.projeto.restaurante.dto.ProdutoComanda;
import br.com.projeto.restaurante.service.Services;

@RestController
@RequestMapping(path = "/api/comanda")
public class Comanda {
	@Autowired
	private Services<ComandaDTO> service;
	
	@PostMapping("")
	public ResponseEntity<String> saveClient(@RequestBody ComandaDTO dao){
		try {
			service.salvar(dao);
			return ResponseEntity.ok("{\"resp\":\"Comanda Salvo\"}");
		} catch (Exception e) {
			return new ResponseEntity<String>("Falha ao salva cliente", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/produto/{idComanda}")
	public ResponseEntity<String> insereProduto(@PathVariable Integer idComanda, @RequestBody  ProdutoComanda produto){ 
		try {
			List<ProdutoComanda> prod = new ArrayList<>();
			prod.add(produto);
			ComandaDTO dao = new ComandaDTO(idComanda, null, null, null, prod);
			service.salvar(dao);
			return ResponseEntity.ok("{\"resp\":\"Comanda Salvo\"}");
		} catch (Exception e) {
			return new ResponseEntity<String>("Falha ao iserir produto na comanda", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/produto/{idProduto}")
	public ResponseEntity<String> removeProduto(@PathVariable Integer idProduto){
		try {
			service.deleteRelacionamento(idProduto);
			return ResponseEntity.ok("{\"resp\":\"Produto removido da comanda\"}");
		} catch (Exception e) {
			return new ResponseEntity<String>("{\"resp\":\"Falha ao remover da comanda\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
