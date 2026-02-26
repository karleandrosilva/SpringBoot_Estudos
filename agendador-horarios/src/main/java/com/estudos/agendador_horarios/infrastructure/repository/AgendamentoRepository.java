package com.estudos.agendador_horarios.infrastructure.repository;

import com.estudos.agendador_horarios.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> { //colocar interface e extends Jpa<Entidade,Long>

    // between = entre os horarios
    Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);
}
