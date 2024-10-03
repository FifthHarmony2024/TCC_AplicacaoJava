package br.com.etechoracio.aplicacaoTcc.service;

import br.com.etechoracio.aplicacaoTcc.entity.Categoria;
import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    public void salvarCategoriasSelecionadas(List<Categoria> categoriasSelecionadas, Prestador prestador) {
        if (categoriasSelecionadas.size() > 5) {
            throw new IllegalArgumentException("Não é permitido selecionar mais de 5 categorias.");
        }
        prestador.setCategorias(categoriasSelecionadas);
    }

}
