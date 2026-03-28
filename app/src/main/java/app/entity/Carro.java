package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // todos os getters (Gera os métodos para pegar os valores)
@Setter // todos os settes (Gera os métodos para alterar os valores)
@AllArgsConstructor // todos os argumentos (Gera o construtor completo, aquele que recebe todos os campos da classe de uma vez)
@NoArgsConstructor // todos os sem argumentos (Gera o construtor vazio/padrão. É obrigatório para o Hibernate conseguir criar os objetos do banco de dados)
@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int ano;

	// RELAÇÃO = Carro pode ter UMA marca e uma Marca pode ter VARIOS carros: (1:n)
	
	@ManyToOne(cascade = CascadeType.ALL) // salvar em cascata para que dê para salvar um carro contendo a marca
	@JsonIgnoreProperties("carros")
	private Marca marca; // obj da classe marca
	
	// Representando CARRO pode ter varios PROPRIETÁRIOS
	@ManyToMany(cascade = CascadeType.ALL) // possibilitar que quando salve o carro, ele salvar também todos os objs e listas que tem dentro (que por padrão não salvam)
	@JoinTable(name = "carro_proprietario") // nome da tabela que une/join as duas
	private List<Proprietario> proprietarios;
}

// testes automatizados
