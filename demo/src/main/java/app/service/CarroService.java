package app.service;

import java.util.Optional;

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
	public Carro findById(Long id) {
		
		 // Utiliza Optional para evitar NullPointerException caso o usuário não seja encontrado.
		Optional<Carro> carro = this.carroRepository.findById(id);
		return carro.get();

	}
}

// PAREI EM 12:48
