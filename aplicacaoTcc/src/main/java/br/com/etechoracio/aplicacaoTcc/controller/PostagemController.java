package br.com.etechoracio.aplicacaoTcc.controller;

import br.com.etechoracio.aplicacaoTcc.dto.PostagemResponseDTO;
import br.com.etechoracio.aplicacaoTcc.service.PostagemService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private PostagemService service;

    @PostMapping("/{idUsuario}")
    public ResponseEntity<PostagemResponseDTO> adicionarPostagem(
            @PathVariable Integer idUsuario,
            @RequestBody PostagemResponseDTO postagemResponseDTO) {
        return service.adicionarPostagem(idUsuario, postagemResponseDTO);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<PostagemResponseDTO>> listarPostagens(@PathVariable Integer idUsuario) {
        List<PostagemResponseDTO> postagens = service.listarPostagensPorPrestador(idUsuario);
        return ResponseEntity.ok(postagens);
    }

    //deletar nao esta funcionando
    @DeleteMapping("/{idPostagem}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable Integer idPostagem) {
        service.deletarPorId(idPostagem);
        return ResponseEntity.noContent().build();
    }
}
