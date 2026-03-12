package com.estudos.agendador_horarios.controller;

import com.estudos.agendador_horarios.infrastructure.entity.Agendamento;
import com.estudos.agendador_horarios.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // avisa que é uma api rest (padrão rest)
@RequiredArgsConstructor // para não criar os construtores na mão
public class AgendamentoController {

    private final AgendamentoService agendamentoService; // chama a service (injeta a  dependencia do service gerada pelo loombok) | final pois não pode ser alterada depois de injetada

    @PostMapping // para salvar (cria e grava dados)
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){ // retorna o save e trata excessões | @RequestBody = converte o JSON enviado na requisição
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento)); // accepted = deu certo e caso não dê, ele responde com o erro
    }

}
