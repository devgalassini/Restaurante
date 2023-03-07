package br.com.projeto.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaginasRestaurante {

	@RequestMapping("/")
	public String home() {
		return "index";	
	}
	
	@RequestMapping("/cliente")
	public String cliente() {
		return "/clientes";	
	}
	
	@RequestMapping(value = "/comandas")
	public String comandasCliente() {
		return "/comandas-cliente";	
	}
	
	@RequestMapping(value = "/produtos")
	public String produtos() {
		return "/produtos";	
	}
	
	@RequestMapping(value = "/comanda")
	public String comandaProduto() {
		return "/comanda-produtos";	
	}
}
