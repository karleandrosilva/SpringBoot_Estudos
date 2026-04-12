package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.entity.Saida;
import app.repository.CalculoRepository;

@SpringBootTest // assinatura da classe
public class CalculoControllerTest {
	
	@Autowired // trazer para  a classe que quer testar
	CalculoController calculoController; // não precisa de private
	
	@MockitoBean // indica que o obj calculoRepository vai ter uma configuração de mock
	CalculoRepository calculoRepository; // instancia a interface repository 
	
	
	@Test
	void cenario01() { // sem retorno e sem visibilidade
		// TESTE DE INTEGRAÇÃO COM MOCKITO (pois vai chamar o repositosry(banco))
		
		// verificar se  retorna o status
		ResponseEntity<List<Saida>> retorno = this.calculoController.findAll(); // 
		assertEquals(HttpStatus.OK, retorno.getStatusCode()); //getStatusCode = pois mostrara o status que deu 
	}  
	
	
	// TESTE DE INTEGRAÇÃO SEM MOCK 
	// 14:33
	
}
