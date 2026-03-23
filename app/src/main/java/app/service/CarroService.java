package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository; // instancia de repository
	
	
	// (intermédio entre controller e repository)

	// métodos vazios
	
	public String save(Carro carro) {
		this.carroRepository.save(carro);
		return "Carro salvo com sucesso!";
	}
	
	public String update(Carro carro, long id) {
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Carro foi atualizado com sucesso!";
	}
	
	public String delete(long id) {
		this.carroRepository.deleteById(id);
		return "Carro foi deletado com sucesso!";
	}
	
	// lista de carros
	public List<Carro> findAll() {
		// receber a lista
		List<Carro> lista = this.carroRepository.findAll();
		return lista; 
		
	}
	
	// retorna um unico carro
	public Carro findById(long id) {
		Carro carro = this.carroRepository.findById(id).get(); // .get() no final
 		return carro;
	}
	
	public List<Carro> findByNome(String nome) {//o que for processado no repository vai retornar
		return this.carroRepository.findByNome(nome);
	}
	
	// metodo de procurar por marca
	public List<Carro> findByMarca(long idMarca) { // receber o id da marca
		Marca marca = new Marca(); // cria uma marca vazia
		marca.setId(idMarca); // seto com base no id q vai receber da controller, pois o usuario  vai enviar o id da marca para filtrar fazendo com que vire um obj da classe marca para poder chamar o metodo do repository que espera uma Marca 
		return this.carroRepository.findByMarca(marca);
	}
	
	// método de procurar anos
	public List<Carro> findAcimaAno(int ano) {
		return this.carroRepository.findAcimaAno(ano); // retorna lista de carros
	}
	
}
