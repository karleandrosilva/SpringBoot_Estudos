package com.estudos.cadastro_usuario.infrastructure.repository;

import com.estudos.cadastro_usuario.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// extende o JPA e o nome da tabela que se referncia (usuario
// o tipo do campo id = INTEGER | mas pode ser LONG
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // adiciona o findyByEmail pois não existe
    Optional<Usuario> findByEmail(String email); // optional = para criar uma excessao/alternativa, caso não exista o (EMAIL) procurado

    // para deletar com email
    @Transactional // caso de algum erro, ele não execulta (não deleta)
    void deletebyEmail(String email);
}
