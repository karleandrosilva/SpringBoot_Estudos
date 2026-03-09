package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	// metodo complementar com filtro
	// lista de carros baseada no nome
	public List<Carro> findByNome(String nome);
	

}
