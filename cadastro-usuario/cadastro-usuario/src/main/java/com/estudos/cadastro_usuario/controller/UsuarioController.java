package com.estudos.cadastro_usuario.controller;

import com.estudos.cadastro_usuario.business.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // padrão rest
@RequestMapping("/usuario") // uri
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; // injetar a  dependencia do service

    // 29:00


}
