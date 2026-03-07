package com.estudos.agendador_horarios.infrastructure.repository;

import com.estudos.agendador_horarios.infrastructure.entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> { //colocar interface e extends Jpa<Entidade,Long>

    // between = entre os horarios
    Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);

    // usa o transactional para caso algo de erraado, a trasacao e cancelada e o bd não fica inconsistente
    @Transactional // anotação para garantir que a operação de delete seja executada | dentro de uma transacao no banco de dados
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente); // cria a query baseado no nome do metodo | vai deletar agendamento que tenha: dataHoraAgendamento e Cliente

    // ver todo mundo que agendou em um dia especifico
    Agendamento findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFim);
}
