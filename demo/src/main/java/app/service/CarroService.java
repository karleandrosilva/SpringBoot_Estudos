package app.service;

import org.springframework.stereotype.Service;

import app.entity.Carro;

@Service
public class CarroService {
	
	//  PROCESSAMENTO
	
	public String save(Carro carro) {
		return ("Carro: " + carro.getNome() + " salvo com sucesso!");
		
	}
	
	// método para buscar um carro pelo id
	// simula a busca de um carro retornando um objeto fixo se o id for 1
	public Carro findById(int id) {
		
		if(id == 1) {
			Carro carro = new Carro();
			
			carro.setModelo("SUV");
			carro.setMarca("abc");
			carro.setNome("nome");
			carro.setAnoFabricacao(1998);
			
			return carro;
		} else {
			return null;
		}
	}
}
