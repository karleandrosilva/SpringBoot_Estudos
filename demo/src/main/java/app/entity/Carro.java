package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 1 - Declara que será uma entidade e que será mapeada para uma tabela no Banco de dados 
public class Carro {
	
	@Id // Para definir que é um id, e marca como uma chave primaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia para gerar um identificador único no banco de dados de forma automática, permitindo que o Hibernate escolha a melhor forma de incremento (como sequências ou tabelas) de acordo com o banco utilizado.
	private Long id;
	private String nome;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
