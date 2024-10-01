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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ModelMapper modelMapper = new ModelMapper();

    private static final String UPLOAD_DIR = "uploads/";


    public ResponseEntity<Prestador> cadastrarPrestador(Prestador prestador) {
        if (prestador.getTipoPrestador() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (prestador.getTipoPrestador() == TipoPrestador.AUTONOMO) {
            if (prestador.getCpf() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            if (repository.findByCpf(prestador.getCpf()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
            prestador.setCnpj(null);
        }

        if (prestador.getTipoPrestador() == TipoPrestador.MICROEMPREENDEDOR) {
            if (prestador.getCnpj() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            if (repository.findByCnpj(prestador.getCnpj()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
            prestador.setCpf(null);
        }

        if (repository.findByLogin(prestador.getLogin()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        prestador.setSenha(passwordEncoder.encode(prestador.getSenha()));
        Prestador savedPrestador = repository.save(prestador);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrestador);
    }

    public ResponseEntity<Usuario> cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (repository.findByLogin(usuario.getLogin()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);  // Login já em uso
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario savedUsuario = repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

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

    //diretorio da foto
    private void criarDiretorioSeNaoExistir() throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
    }

    public ResponseEntity<String> uploadFotoPerfil(Integer idUsuario, MultipartFile file) {
        Optional<Usuario> usuarioOpt = repository.findById(Long.valueOf(idUsuario));
        if (!usuarioOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        try {
            criarDiretorioSeNaoExistir();

            String fileName = idUsuario + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + fileName);

            Files.write(filePath, file.getBytes());

            Usuario usuario = usuarioOpt.get();
            usuario.setFotoPerfil(fileName);
            repository.save(usuario);

            return ResponseEntity.status(HttpStatus.OK).body("Foto de perfil enviada com sucesso");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao fazer upload da foto");
        }
    }

    public ResponseEntity<String> removerFotoPerfil(Integer idUsuario) {
        Optional<Usuario> usuarioOpt = repository.findById(Long.valueOf(idUsuario));
        if (!usuarioOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();
        if (usuario.getFotoPerfil() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não tem uma foto de perfil");
        }

        try {
            Path filePath = Paths.get(UPLOAD_DIR + usuario.getFotoPerfil());
            Files.deleteIfExists(filePath);

            usuario.setFotoPerfil(null);
            repository.save(usuario);

            return ResponseEntity.status(HttpStatus.OK).body("Foto de perfil removida com sucesso");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao remover a foto de perfil");
        }
    }

}
