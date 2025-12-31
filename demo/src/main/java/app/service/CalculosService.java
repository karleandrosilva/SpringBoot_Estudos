package app.service;

import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;

@Service // indica que esta interface é um componente de acesso a dados (camada de repositório).
public class CalculosService {
	
	// método de somar
	public Resultado somar(Entrada entrada) {
		
		Resultado resultado = new Resultado();
		Integer soma = 0;
		
		if(entrada.getLista() != null) {
			for (int i = 0 ; i < entrada.getLista().size(); i++) {
				soma += entrada.getLista().get(i);
			}
		}
		
		resultado.setSoma(soma);
		return resultado;
		
	}

}
