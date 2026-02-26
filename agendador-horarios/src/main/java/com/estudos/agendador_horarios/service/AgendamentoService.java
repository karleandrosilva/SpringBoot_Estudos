package com.estudos.agendador_horarios.service;

import com.estudos.agendador_horarios.infrastructure.entity.Agendamento;
import com.estudos.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service // para mostrar que é uma service
@RequiredArgsConstructor // injeção de dependencia |
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository; // chama injentando a dependencia

    // salvar agendamento (verificar primeiro se a data e hora já está reservada)
    public Agendamento salvarAgendamento(Agendamento agendamento){

        // só consiga agendar uma pessoa a cada hora | gap de 1h
        // não permite que ninguem seja agendado em horarios conflitantes
        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1); // verificar se dentro do gap de 1h nao tem ninguem agendado


        Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(), horaAgendamento,horaFim);

        //21:47
    }


}
