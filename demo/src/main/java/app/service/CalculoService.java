package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import app.dto.Entrada;
import app.entity.Entrada;
import app.entity.Saida;
import app.repository.CalculoRepository;

@Service
public class CalculoService {

	@Autowired
	private CalculoRepository calculoRepository;
	
	public Saida calcular(Entrada entrada) {

		Saida saida = new Saida();
		saida.setSoma(this.somar(entrada.getLista()));
		saida.setMaiorNumeroLista(this.buscarMaiorNumero(entrada.getLista()));

		saida = this.calculoRepository.save(saida);
		
		return saida;
	}
	
	public List<Saida> findAll() {
		return this.calculoRepository.findAll();
	}
	
	public int somar(List<Integer> lista) {
		int soma = 0;
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) != null) { // corigido depois do teste (ignora nulos)
				soma += lista.get(i);
			}
		}
		return soma;
	}
	
	public int buscarMaiorNumero(List<Integer> lista) {
		int maiorNumero = 0;
		
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) > maiorNumero)
				maiorNumero = lista.get(i);
		}
		return maiorNumero;
	}
	
}