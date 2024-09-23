package br.com.etechoracio.aplicacaoTcc.service;

import br.com.etechoracio.aplicacaoTcc.dto.PostagemResponseDTO;
import br.com.etechoracio.aplicacaoTcc.entity.Postagem;
import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import br.com.etechoracio.aplicacaoTcc.repository.PostagemRepository;
import br.com.etechoracio.aplicacaoTcc.repository.PrestadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository repository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public ResponseEntity<PostagemResponseDTO> adicionarPostagem(Integer idUsuario, PostagemResponseDTO postagemDTO) {

        Prestador prestador = prestadorRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Prestador não encontrado"));

        Postagem postagem = modelMapper.map(postagemDTO, Postagem.class);
        postagem.setPrestador(prestador);
        postagem.setDtPostagem(LocalDate.now());

        Postagem novaPostagem = repository.save(postagem);

        PostagemResponseDTO novaPostagemDTO = modelMapper.map(novaPostagem, PostagemResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPostagemDTO);
    }

    public List<PostagemResponseDTO> listarPostagensPorPrestador(Integer idUsuario) {
        Prestador prestador = prestadorRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Prestador não encontrado"));

        return prestador.getPostagens().stream()
                .map(postagem -> modelMapper.map(postagem, PostagemResponseDTO.class))
                .collect(Collectors.toList());
    }

    public void deletarPorId(Integer idPostagem) {
        repository.deleteById(idPostagem);
    }
}
