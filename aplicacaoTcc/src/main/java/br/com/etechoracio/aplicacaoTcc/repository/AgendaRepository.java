package br.com.etechoracio.aplicacaoTcc.repository;

import br.com.etechoracio.aplicacaoTcc.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface AgendaRepository extends JpaRepository<Agenda,Integer> {

    List<Agenda> findByPrestadorIdUsuario(Integer idUsuario);

    // ver a agenda pelo o dia
    Optional<Agenda> findByPrestadorIdUsuarioAndDiaServico(Integer idUsuario, LocalDate diaServico);

}
