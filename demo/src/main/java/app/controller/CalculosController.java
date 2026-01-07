package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Entrada;
import app.entity.Resultado;
import app.service.CalculosService;

@RestController // indica que esta classe é um Controller REST (reponsável por expor os endpoints), voltado para APIs REST.
@RequestMapping("/calculos") // define a rota base para os endpoints desse Controller.
public class CalculosController {
	
	@Autowired // Realiza a injeção de dependência do CalculosService gerenciado pelo Spring
	private CalculosService calculosService; // declara o obj (responsável pelas regras de negócio dos cálculos)
	
	// metódo (e endpoint que pode ser consumido externamente)
	
	@GetMapping("/calcular") // verbo http (Mapeia requisições HTTP do tipo GET/BUSCAR)
	public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada) { // retornar status (tratar com try catch)
		
		try {
			Resultado resultado = this.calculosService.calcular(entrada);
			return new ResponseEntity<Resultado>(resultado, HttpStatus.OK); // retorna o resultado e o status da requisição
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // retorna o status da requisição: erro causado por dados inválidos do cliente
		}
		
	}

}

