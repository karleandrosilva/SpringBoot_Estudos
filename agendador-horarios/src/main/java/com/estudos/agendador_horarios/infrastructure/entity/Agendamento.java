package com.estudos.agendador_horarios.infrastructure.entity;

// começa com a entity

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // para dizer que é uma entidade
@Table(name = "agendamento") //nome da tabela (sempre em minusculo)
public class Agendamento {

    @Id // dizer que é um id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatizamente gerar os id
    private Long id;
    private String servico;
    private String profissional;
    private LocalDateTime dataHoraAgendamento;
    private String cliente;
    private String telefoneCliente;
    private LocalDateTime dataIsercao = LocalDateTime.now(); // para pegar a hora exata
    // parou em: 14:40
}
