package br.com.etechoracio.aplicacaoTcc.repository;

import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import br.com.etechoracio.aplicacaoTcc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);

    Optional<Prestador> findByCpf(String cpf);

    Optional<Prestador> findByCnpj(String cnpj);
}
