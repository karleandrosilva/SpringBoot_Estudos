package com.estudos.agendador_horarios.service;

import com.estudos.agendador_horarios.infrastructure.entity.Agendamento;
import com.estudos.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Service // para mostrar que é uma service
@RequiredArgsConstructor // injeção de dependencia | (lombook cria construtor com os atributos final)
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository; // chama injentando a dependencian  (a Service vai usar o Repository para acessar o BD)

    // metodo de salvar agendamento (verifica primeiro se a data e hora já está reservada)
    public Agendamento salvarAgendamento(Agendamento agendamento){

        // só consiga agendar uma pessoa a cada hora | gap de 1h | não permite que ninguem seja agendado em horarios conflitantes
        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento(); // pega a hora escolhida pelo cliente
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1); // verifica se dentro do gap de 1h nao tem ninguém agendado (também define que cada agendamento dura 1h)

        Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(
                agendamento.getServico(), horaAgendamento,horaFim
        ); // verifica se já existe alguém nesse horário

        if (Objects.nonNull(agendados)){ // se o agendamentos já existe (nn posso preecher outro) | se não está nulo
            throw new RuntimeException("Horário já está preechido");
        }
        return agendamentoRepository.save(agendamento); // se não... salva o agendamento
    }

    // metodo para deletar agendamento
    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente){
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente); // chama a repository | a remocao é feita por 2 criterios: data e hora do agendamento e o nome do cliente
    }

    // metodo de buscar por datas
    public Agendamento buscarAgendamentosDia(LocalDate data){
        LocalDateTime primeiraHoraDia = data.atStartOfDay(); // hora inicial
        LocalDateTime horaFinalDia = data.atTime(23,59,59); // hora final | fecha 23:59
    }

}
