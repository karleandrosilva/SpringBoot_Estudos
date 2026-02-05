package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro) {
		
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable long id) {
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		
	}
	
	// lista de carros
	@GetMapping("/findAll")
	public ResponseEntit<List<Carro>> findAll() {
		
	}
	
	// retorna um unico carro
	@GetMapping("/findById/{id}")
	public ResponseEntit<Carro> findById(@PathVariable long id) {
		
	}
}
