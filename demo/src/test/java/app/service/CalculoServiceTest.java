package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // traz um contexto para existir as outras anotations para testes (assinatura)
public class CalculoServiceTest {
	
	
	// não precisa de visibilidade (private)
	@Autowired // deixa para dar uma instancia (coloca na classe que quer testar de fato)
	CalculoService calculoService;
	
	// primeiro cenário de teste (método)
	@Test
	void cenario01() { // sem retorno (void = padrão)
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.calculoService.somar(lista);
		
		assertEquals(11, retorno); //assertEquals = verifica se dois valores são iguais (esperado, obtido)
	}
	
	@Test
	void cenario02() { 
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.calculoService.somar(lista);
		
		assertEquals(9, retorno);
		
		// identificou uma falha na lógica, pois não aceita números nulos. Arrumar na logica (service)
	}
	
	@Test
	void cenario03() { 
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(4);
		lista.add(5);
		
		assertThrows(Exception.class, () -> {
			int retorn = this.calculoService.somar(lista);
		});
	}

}
