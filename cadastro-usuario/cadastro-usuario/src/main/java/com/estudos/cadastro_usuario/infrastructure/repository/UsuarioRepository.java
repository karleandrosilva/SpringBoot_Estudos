package com.estudos.cadastro_usuario.infrastructure.repository;

import com.estudos.cadastro_usuario.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // extende o JPA e o nome da tabela que se referncia (usuario
    // o tipo do campo id = INTEGER | mas pode ser LONG
}
