package br.com.etechoracio.aplicacaoTcc.service;

import br.com.etechoracio.aplicacaoTcc.dto.UsuarioResponseDTO;
import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import br.com.etechoracio.aplicacaoTcc.entity.Usuario;
import br.com.etechoracio.aplicacaoTcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public ResponseEntity<Prestador> cadastrarPrestador( Prestador prestador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(prestador));
    }

    public ResponseEntity<Usuario> cadastrarUsuario( Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    //Validacao de email ou telefone

    private ModelMapper modelMapper = new ModelMapper();
    public List<UsuarioResponseDTO> listar(){
        var usuarios = repository.findAll();
        var resultado = usuarios.stream().map(
                        e-> modelMapper.map(e, UsuarioResponseDTO.class))
                .collect(Collectors.toList());
        return resultado;
    }

}
