package com.estudos.agendador_horarios.service;

import com.estudos.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // para mostrar que é uma service
@RequiredArgsConstructor // injeção de dependencia |
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;


}
