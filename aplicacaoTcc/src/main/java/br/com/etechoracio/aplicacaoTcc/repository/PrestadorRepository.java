package br.com.etechoracio.aplicacaoTcc.repository;

import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<Prestador,Integer> {
}
