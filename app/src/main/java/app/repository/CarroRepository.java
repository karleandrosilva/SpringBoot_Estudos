package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Carro;
import app.entity.Marca;


public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	// metodo complementar com filtro
	// lista de carros baseada no nome
	public List<Carro> findByNome(String nome);
	public List<Carro> findByMarca(Marca marca);
	
	// lista de objs da classe carro, que possuem acima de um ano de fabricacao
	@Query("FROM Carro c WHERE c.ano > :ano") // (:parametro)
	public List<Carro> findAcimaAno(int ano);
}
