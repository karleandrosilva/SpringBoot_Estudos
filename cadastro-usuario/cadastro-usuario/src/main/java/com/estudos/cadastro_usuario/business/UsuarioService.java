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
        usuarioRepository.deletebyEmail(email);
    }

    // método update

}
