package br.com.etechoracio.aplicacaoTcc.controller;

import br.com.etechoracio.aplicacaoTcc.dto.UsuarioResponseDTO;
import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import br.com.etechoracio.aplicacaoTcc.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.etechoracio.aplicacaoTcc.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cliente")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        return service.cadastrarUsuario(usuario);
    }

    @PostMapping("/prestador")
    public ResponseEntity<Prestador> cadastrarPrestador(@RequestBody Prestador prestador) {
        return service.cadastrarPrestador(prestador);
    }

    public List<UsuarioResponseDTO> listar(){return service.listar();}


}
