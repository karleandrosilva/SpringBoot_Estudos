package com.estudos.ApiRickAndMorty.controller;

import com.estudos.ApiRickAndMorty.client.RickAndMortyClient;
import com.estudos.ApiRickAndMorty.response.CharacterResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController // requisições request
@AllArgsConstructor
@RequestMapping("/webclient") // uri base dos endpoints
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyClient; //instanciar

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable int id){
        return rickAndMortyClient.findAndCharacterById(id);
    }

}
