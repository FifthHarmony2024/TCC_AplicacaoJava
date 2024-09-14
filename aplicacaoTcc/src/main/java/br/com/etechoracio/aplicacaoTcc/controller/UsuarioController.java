package br.com.etechoracio.aplicacaoTcc.controller;

import br.com.etechoracio.aplicacaoTcc.entity.Usuario;
import br.com.etechoracio.aplicacaoTcc.enuns.TipoUsuario;
import br.com.etechoracio.aplicacaoTcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

   // @PostMapping
  //  public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
//
        //if (usuario.getTipoUsuario == TipoUsuario.CLIENTE) {
      //      System.out.println("Cadastrando como Cliente");
        //}
       // else if (usuario.getTipoUsuario() == TipoUsuario.PRESTADOR) {
      //      System.out.println("Cadastrando como Prestador");
    //    }

    //    return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
   // }
}
