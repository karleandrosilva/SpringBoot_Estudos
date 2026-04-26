package com.estudos.ApiRickAndMorty.response;

import lombok.Data;

import java.util.List;

@Data // para não precisar fazer os getters e setters
public class CharacterResponse {
    private int id;
    private String name;
    private String status;
    private String species;
    private String image;
    private List<String> episode;
}
