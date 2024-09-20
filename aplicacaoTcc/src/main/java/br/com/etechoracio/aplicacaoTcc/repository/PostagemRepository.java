package br.com.etechoracio.aplicacaoTcc.repository;

import br.com.etechoracio.aplicacaoTcc.entity.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem,Integer> {
}
