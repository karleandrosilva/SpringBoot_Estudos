package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController // para indicar que é uma controler com requisição
@RequestMapping("/carro") // o endpoint
public class CarroController {
	
	// instancia a classe service junto com o @Autowired para instanciar a dependencia
	@Autowired
	private CarroService carroService;
	
	// método para salvar
	@PostMapping("/save") // mapeamento do verbo http (post para salvar)
	public ResponseEntity<String> save(@RequestBody Carro carro) {
		
		try {
			String mensagem = this.carroService.save(carro);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK); // retorna a mensagem e o status HTTP da requisição 
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo errado ao salvar!", HttpStatus.BAD_REQUEST); // mensagem e status de erro= BAD_REQUEST
		}
		
	}
	
	// método para buscar um carro pelo id
	@GetMapping("/findById/{id}") // 
	public ResponseEntity<Carro> findById(@PathVariable Long id) {
		
		try {
			Carro carro = this.carroService.findById(id);
			return new ResponseEntity<>(carro, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
}

