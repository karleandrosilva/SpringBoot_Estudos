package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{ //  Para fazer a conexão com o banco, estende a interface JpaRepository, passando como parâmetros:a entidade que será gerenciada (Carro) e o tipo do ID da entidade (Long).

	// Não é necessário escrever os métodos aqui, pois a interface JpaRepository já fornece vários métodos prontos para operações básicas como salvar, buscar, atualizar e deletar dados.
	
}
