package com.estudos.ApiRickAndMorty.client;

import com.estudos.ApiRickAndMorty.response.CharacterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service // servico do spring
@Slf4j // para não precisar escrever o log
public class RickAndMortyClient {

    // url para servir como base
    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    // Declaração do cliente HTTP reativo
    private final WebClient webClient; // 'final' garante que não será alterado após a inicialização

    // Método que busca um personagem pelo ID
    // Retorna um Mono (resposta assíncrona que terá 0 ou 1 resultado)
    public  Mono<CharacterResponse> findAndCharacterById(int id) {
        log.info("buscando o personagem com o id [{}]", id);

        // início da requisição HTTP
        return  (Mono<CharacterResponse>) webClient
                .get() // define o método HTTP como GET
                .uri("/character/"+ id) // monta o caminho final: base + /character/{id} | ex = rickandmortyapi.com/api/character/1
                .accept(MediaType.APPLICATION_JSON) // define que a aplicação espera receber JSON como resposta
                .retrieve() // inicia a execução da chamada
                .onStatus(HttpStatusCode::is4xxClientError, // Trata erros do tipo 4xx (erro do cliente, ex: 404)
                        erro-> Mono.error(new RuntimeException("Verifique os parametros")))
                .bodyToMono(CharacterResponse.class);  // converte o corpo da resposta (JSON) para um objeto Java
    }
}
