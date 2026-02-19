package com.estudos.cadastro_usuario.controller;

import com.estudos.cadastro_usuario.business.UsuarioService;
import com.estudos.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // padrão rest
@RequestMapping("/usuario") // uri base dos endpoints
@RequiredArgsConstructor // lombok gera um constrtutor com as dependencias obrigatórias
public class UsuarioController {

    // 'final' indica que essa dependência não pode ser alterada depois de injetada
    private final UsuarioService usuarioService; // injetar a  dependencia do service gerada pelo loombok

    // 4 verbos

    @PostMapping // criar/gravar dados
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {  // @RequestBody = converte o JSON enviado na requisição
        usuarioService.salvarUsuario(usuario); // chama a camada de serviço para persistir no banco
        return ResponseEntity.ok().build(); //  retorna uma resposta HTTP 200 OK
    }

    @GetMapping // buscar dado
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) { // recebe um parametro email | @RequestParam = o valor virá da URL como parâmetro de consulta.
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email)); // retorna HTTP 200 OK junto com o objeto no corpo da resposta (JSON)
    }

    @DeleteMapping // deletar dado
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping // atualizar tudo
    public ResponseEntity<Void> atualizarUsuarioPorID(@RequestParam Integer id, @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
