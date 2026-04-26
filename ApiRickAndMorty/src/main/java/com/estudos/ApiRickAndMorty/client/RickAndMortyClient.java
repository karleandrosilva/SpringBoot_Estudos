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

    // ser estática para não ser alterada
    private final WebClient webClient;

    // client
    public  Mono<CharacterResponse> findAndCharacterById(int id) {
        log.info("buscando o personagem com o id [{}]", id);
        return  (Mono<CharacterResponse>) webClient
                .get()
                .uri("/character/"+ id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        erro-> Mono.error(new RuntimeException("Verifique os parametros")))
                .bodyToMono(CharacterResponse.class);
    }

}
