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
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public ResponseEntity<Prestador> cadastrarPrestador(Prestador prestador) {

        if (prestador.getTipoPrestador() == TipoPrestador.AUTONOMO) {
            if (prestador.getCpf() == null ) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            prestador.setCnpj(null);
        } else if (prestador.getTipoPrestador() == TipoPrestador.MICROEMPREENDEDOR) {
            if (prestador.getCnpj() == null ) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            prestador.setCpf(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(prestador));
    }

    //validacao de cnpj
    // validacao de cpf
    // validacao de email
    //validacao de telefone
    // validacao de cep
    //validacao de senhas iguais - senha e confirmar senha

    //alterar dados
    // mudar foto de perfil

    public ResponseEntity<Usuario> cadastrarUsuario( Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    private ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioResponseDTO> listar() {
        var usuarios = repository.findAll();
        var resultado = usuarios.stream().map(usuario -> {
            if (usuario instanceof Prestador) {
                return modelMapper.map(usuario, PrestadorResponseDTO.class);
            } else {
                return modelMapper.map(usuario, UsuarioResponseDTO.class);
            }
        }).collect(Collectors.toList());

        return resultado;
    }


}
