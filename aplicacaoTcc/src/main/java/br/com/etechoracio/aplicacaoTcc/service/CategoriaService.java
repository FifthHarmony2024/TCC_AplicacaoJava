package br.com.etechoracio.aplicacaoTcc.service;

import br.com.etechoracio.aplicacaoTcc.entity.Categoria;
import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import br.com.etechoracio.aplicacaoTcc.repository.CategoriaRepository;
import br.com.etechoracio.aplicacaoTcc.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    public void salvarCategoriasSelecionadas(List<String> categoriasSelecionadasLabels, Integer prestadorId) {
        if (categoriasSelecionadasLabels.size() > 3) {
            throw new IllegalArgumentException("Não é permitido selecionar mais de 3 categorias.");
        }

        Prestador prestador = prestadorRepository.findById(prestadorId)
                .orElseThrow(() -> new IllegalArgumentException("Prestador não encontrado"));

        List<Categoria> categorias = categoriaRepository.findByNomeCategoriaIn(categoriasSelecionadasLabels);

        prestador.setCategorias(categorias);

        prestadorRepository.save(prestador);
    }
}
