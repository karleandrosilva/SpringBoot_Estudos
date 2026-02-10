package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

	@Autowired
	private CarroService carroService;

	// métodos de CRUD, mas com anonations para manipular as requisições HTTP

	@PostMapping("/save") // Mapeia requisições HTTP do tipo POST para o endpoint /save
	public ResponseEntity<String> save(@RequestBody Carro carro) { 
		// ResponseEntity permite retornar um corpo de resposta junto com o status HTTP
		 // @RequestBody converte o JSON da requisição em um objeto Carro
		try {
			String mensagem = this.carroService.save(carro); // Chama o método save da camada Service, enviando o objeto Carro
			return new ResponseEntity<>(mensagem, HttpStatus.CREATED);  // Retorna a mensagem de sucesso com o status HTTP 201 (CREATED)
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // Retorna status HTTP 400 (BAD_REQUEST) indicando erro na requisição
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable Long id) {  // @PathVariable captura o valor do id presente na URL
		try {
			String mensagem = this.carroService.update(carro, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.carroService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// lista de carros
	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll() {
		try {
			List<Carro> lista = this.carroService.findAll(); // recebe lista de carros
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// retorna um unico carro
	@GetMapping("/findById/{id}") 
	public ResponseEntity<Carro> findById(@PathVariable long id) {
		try {
			Carro carro = this.carroService.findById(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
