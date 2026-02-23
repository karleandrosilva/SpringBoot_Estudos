package com.estudos.agendador_horarios.infrastructure.repository;

import com.estudos.agendador_horarios.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> { //colocar interface e extends Jpa<Entidade,Long>
}
