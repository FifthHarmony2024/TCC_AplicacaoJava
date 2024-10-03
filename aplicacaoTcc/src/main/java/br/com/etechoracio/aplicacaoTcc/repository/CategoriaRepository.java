package br.com.etechoracio.aplicacaoTcc.repository;

import br.com.etechoracio.aplicacaoTcc.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
