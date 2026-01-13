package app.service;

import org.springframework.stereotype.Service;

import app.entity.Carro;

@Service
public class CarroService {
	
	//  PROCESSAMENTO
	
	public String save(Carro carro) {
		return ("Carro: " + carro.getNome() + " salvo com sucesso!");
		
	}

}
