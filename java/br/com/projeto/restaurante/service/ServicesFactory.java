package br.com.projeto.restaurante.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ServicesFactory {
	private static Map<String, Services<?>> services = new HashMap<>();
	
	private ServicesFactory(List<Services<?>> list) {
		list.stream().forEach(s -> services.put(s.serviceName(), s));
	}
	
	public static Services<?> getService(String type){
		return services.get(type);
	}
}
