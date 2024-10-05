package br.com.etechoracio.aplicacaoTcc.controller;

import br.com.etechoracio.aplicacaoTcc.entity.Categoria;
import br.com.etechoracio.aplicacaoTcc.repository.CategoriaRepository;
import br.com.etechoracio.aplicacaoTcc.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/selecionar")
    public void selecionarCategorias(@RequestParam List<String> categorias, @RequestParam Integer prestadorId) {
        categoriaService.salvarCategoriasSelecionadas(categorias, prestadorId);
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
}
