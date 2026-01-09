package app.service;

import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;

@Service // indica que esta interface é um componente de acesso a dados (camada de repositório).
public class CalculosService {
	
	// método de calcular
	public Resultado calcular(Entrada entrada) {
		
		Resultado resultado = new Resultado(); // instancia 
		Integer soma = 0; 
		
		Integer menorValor = entrada.getLista().get(0);
		Integer maiorValor = entrada.getLista().get(0);
		
		if(entrada.getLista() != null) { // se a lista não estiver vazia
			
			for (int i = 0 ; i < entrada.getLista().size(); i++) { // percorre a lista
				soma += entrada.getLista().get(i); // soma os números
				
				// para saber o numero é menor
				if (menorValor >  entrada.getLista().get(i)) {
					menorValor = entrada.getLista().get(i);
				} 
				
				// para saber o número maior
				if (maiorValor < entrada.getLista().get(i)) {
					maiorValor = entrada.getLista().get(i);
				} 
			}
		}
		
		resultado.setSoma(soma); // coloca o valor da soma em resultado (setei)
		double media = soma/entrada.getLista().size(); // media
		resultado.setMedia(media);
		
		resultado.setMenor(menorValor);
		resultado.setMaior(maiorValor);
		
		Integer total = entrada.getLista().size();
		resultado.setTotal(total);
		
		return resultado;
		
	}

}
