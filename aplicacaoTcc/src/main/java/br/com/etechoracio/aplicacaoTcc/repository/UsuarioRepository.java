package br.com.etechoracio.aplicacaoTcc.repository;

import br.com.etechoracio.aplicacaoTcc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByLogin(String login);
}
