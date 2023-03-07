package br.com.projeto.restaurante.connections.impl;

import java.util.Collections;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

import br.com.projeto.restaurante.connections.RepositorioCep;
import br.com.projeto.restaurante.dto.EnderecoDTO;

@Qualifier("ViaCep")
@Service
public class ViaCep implements RepositorioCep<EnderecoDTO>{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${app.connection.viacep.get.url}")
	private String url;
	
	@Override
	public EnderecoDTO getCepData(String cep) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.url.replace("?", cep));
		JSONObject response = new JSONObject(
        		restTemplate.exchange(
        				builder.toUriString(),
        				HttpMethod.GET,
        				this.buildHttpEntity(),
        				String.class));
		return parseJson(response);
	}
	
	private HttpEntity<String> buildHttpEntity(){
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        return new HttpEntity<>(headers);
	}
	
	private EnderecoDTO parseJson(JSONObject json) {
		return new Gson().fromJson(json.getString("body"), EnderecoDTO.class); 
	}

}