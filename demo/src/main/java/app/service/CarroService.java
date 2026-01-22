package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {
	//  PROCESSAMENTO
	
	@Autowired // cria uma instancia 
	private CarroRepository carroRepository; // cria a dependencia
	
	public String save(Carro carro) {
		
		this.carroRepository.save(carro); // Salva o objeto Carro no banco de dados.
		
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

// PAREI EM 12:48
