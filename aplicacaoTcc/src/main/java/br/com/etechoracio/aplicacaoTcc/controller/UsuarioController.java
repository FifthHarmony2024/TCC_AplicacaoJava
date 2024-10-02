package br.com.etechoracio.aplicacaoTcc.controller;

import br.com.etechoracio.aplicacaoTcc.dto.UsuarioResponseDTO;
import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import br.com.etechoracio.aplicacaoTcc.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.etechoracio.aplicacaoTcc.service.UsuarioService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @PostMapping("/cliente")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid Usuario usuario) {
        return service.cadastrarUsuario(usuario);
    }

    @PostMapping("/prestador")
    public ResponseEntity<Prestador> cadastrarPrestador(@RequestBody @Valid Prestador prestador) {
        return service.cadastrarPrestador(prestador);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar(){return service.listar();}

    @PostMapping("/{id}/uploadFoto")
    public ResponseEntity<String> uploadFotoPerfil(@PathVariable Integer idUsuario, @RequestParam("file") MultipartFile file) {
        return service.uploadFotoPerfil(idUsuario, file);
    }
}



