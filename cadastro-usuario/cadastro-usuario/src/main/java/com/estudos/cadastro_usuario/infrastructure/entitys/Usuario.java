package com.estudos.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // para fazer update
@Table(name= "usuario") // indica que é uma tabela | coloca o nome da tabela em name
@Entity // indica que é uma entidade no bd
public class Usuario {

    @Id // indica identificador unico
    @GeneratedValue(strategy = GenerationType.AUTO) // gera automaticamente
    private Integer id; // integer pois não vai ter muitos dados

    @Column(name = "email", unique = true) //coluna email | unique : email tem que ser unico
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;
}
