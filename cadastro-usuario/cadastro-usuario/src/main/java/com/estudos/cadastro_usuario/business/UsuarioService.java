package com.estudos.cadastro_usuario.business;

import com.estudos.cadastro_usuario.infrastructure.entitys.Usuario;
import com.estudos.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // indica que é a classe de serviço
public class UsuarioService {

    // para usar o métodos tem que usar o repository (injetar a dependencia do repository dentro do service)
    @Autowired
    private UsuarioRepository usuarioRepository;

    // método de salvar
    public void salvarUsuario(Usuario usuario){
        usuarioRepository.saveAndFlush(usuario); // salva e fecha a conexão com o bd
    }

    // método de buscar usuarios por email

    // (se quer buscar por cpf é só colocar findByCpf | idade  = findByIdade)

    public Usuario buscarUsuarioPorEmail(String email) {
        // adiciona o findyByEmail no Repository, pois não existe no JPA Repository
        return usuarioRepository.findByEmail(email).orElseThrow( // tratar o optional para retornar uma excessao personalizada
                () -> new RuntimeException("Email não encontrado") // sera executado se não existir o (EMAIL)
        );
    }

    // deletar usuario por email
    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

    // método update
    // jogada para que caso queira só atualizar um atributo/coluna usar o ternário
    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        // buscar os dados do usuario x
        Usuario usuarioEntity = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Usuario usuarioAtualizado = Usuario.builder() // verifica se o usuario passou no body o email
                .id(usuarioEntity.getId())
                .email(usuario.getEmail() != null ?
                        usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ?
                        usuario.getNome() : usuarioEntity.getNome())
                // se tiver mais atributos, colocar TODOS
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }
}
