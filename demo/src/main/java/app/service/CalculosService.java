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
		
		if(entrada.getLista() != null) { // se a lista não estiver vazia
			for (int i = 0 ; i < entrada.getLista().size(); i++) { // percorre a lista
				soma += entrada.getLista().get(i); // soma os números
				
				
				
			}
		}
		
		resultado.setSoma(soma); // coloca o valor da soma em resultado (setei)
		double media = soma/entrada.getLista().size(); // media
		resultado.setMedia(media);
		
		Integer total = entrada.getLista().size();
		resultado.setTotal(total);
		
		
		
		return resultado;
		
	}

}
