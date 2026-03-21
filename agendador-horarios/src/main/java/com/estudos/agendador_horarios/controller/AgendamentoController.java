package com.estudos.agendador_horarios.controller;

import com.estudos.agendador_horarios.infrastructure.entity.Agendamento;
import com.estudos.agendador_horarios.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController // avisa que é uma api rest (padrão rest)
@RequestMapping("/agendamentos") // uri
@RequiredArgsConstructor // para não criar os construtores na mão
public class AgendamentoController {

    private final AgendamentoService agendamentoService; // chama a service (injeta a  dependencia do service gerada pelo loombok) | final pois não pode ser alterada depois de injetada

    @PostMapping // para salvar (cria e grava dados)
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){ // retorna o save e trata excessões | @RequestBody = converte o JSON enviado na requisição
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.salvarAgendamento(agendamento)); // retorna status 201 indicando que o recurso foi criado
    }

    @DeleteMapping // para deletar dado
    public ResponseEntity<Void> deletarAgendamento(@RequestParam LocalDateTime dataHoraAgendamento, @RequestParam String cliente){ // @RequestParam = o valor virá da URL como parâmetro de consulta

        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente); // chama a camada da service, para a regra de negocio | tem que ser na ordem igual na service
        return ResponseEntity.noContent().build(); //.noContent() = retorna status HTTP 404 (indicando que foi excluido) e nao tem nada para retornar na resposta
    }

    @GetMapping  // buscar dado
    public ResponseEntity<Agendamento> buscarAgendamentosDoDia(@RequestParam LocalDate data){ // recebe o parametro data pela URL
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data)); // retorno
    }

    @PutMapping // altera um dado
    public ResponseEntity<Agendamento> alterarAgendamentos(@RequestBody Agendamento agendamento, @RequestParam LocalDateTime dataHoraAgendamento, @RequestParam String cliente){
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAgendamento));
    }
}

// 44:00
