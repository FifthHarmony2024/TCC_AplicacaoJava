package br.com.etechoracio.aplicacaoTcc.service;

import br.com.etechoracio.aplicacaoTcc.dto.PrestadorResponseDTO;
import br.com.etechoracio.aplicacaoTcc.dto.UsuarioResponseDTO;
import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import br.com.etechoracio.aplicacaoTcc.entity.Usuario;
import br.com.etechoracio.aplicacaoTcc.enuns.TipoPrestador;
import br.com.etechoracio.aplicacaoTcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<Prestador> cadastrarPrestador(Prestador prestador) {
        if (prestador.getTipoPrestador() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (prestador.getTipoPrestador() == TipoPrestador.AUTONOMO) {
            if (prestador.getCpf() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            prestador.setCnpj(null);
        } else if (prestador.getTipoPrestador() == TipoPrestador.MICROEMPREENDEDOR) {
            if (prestador.getCnpj() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            prestador.setCpf(null);
        }

        prestador.setSenha(passwordEncoder.encode(prestador.getSenha()));
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(prestador));
    }

    public ResponseEntity<Usuario> cadastrarUsuario(Usuario usuario) {
        try {
            if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            // Verifica se o usuário já existe
            Optional<Usuario> existingUser = repository.findByLogin(usuario.getLogin());
            if (existingUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }

            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioResponseDTO> listar() {
        var usuarios = repository.findAll();
        return usuarios.stream().map(usuario -> {
            if (usuario instanceof Prestador) {
                return modelMapper.map(usuario, PrestadorResponseDTO.class);
            } else {
                return modelMapper.map(usuario, UsuarioResponseDTO.class);
            }
        }).collect(Collectors.toList());
    }
}
