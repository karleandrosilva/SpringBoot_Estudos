package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Carro;

@Service
public class CarroService {
	
	
	// (intermédio entre controller e repository)

	// métodos vazios
	
	public String save(Carro carro) {
		// implementar
		return "Carro salvo com sucesso!";
	}
	
	public String update(Carro carro, long id) {
		// implementar
		return "Carro foi atualizado com sucesso!";
	}
	
	public String delete(long id) {
		// implementar
		return "Carro foi deletado com sucesso!";
	}
	
	// lista de carros
	public List<Carro> findAll() {
		// implementar
		return null; // só pra nao dar erro
		
	}
	
	// retorna um unico carro
	public Carro findById(long id) {
		// implementar
		return null;
	}
}
