package br.com.etechoracio.aplicacaoTcc.service;

import br.com.etechoracio.aplicacaoTcc.dto.AgendaResponseDTO;
import br.com.etechoracio.aplicacaoTcc.entity.Agenda;
import br.com.etechoracio.aplicacaoTcc.entity.Prestador;
import br.com.etechoracio.aplicacaoTcc.repository.AgendaRepository;
import br.com.etechoracio.aplicacaoTcc.repository.PrestadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<AgendaResponseDTO> listarAgendasPorPrestador(Integer idUsuario) {
        List<Agenda> agendas = agendaRepository.findByPrestadorIdUsuario(idUsuario);
        return agendas.stream()
                .map(agenda -> modelMapper.map(agenda, AgendaResponseDTO.class))
                .collect(Collectors.toList());
    }

    public AgendaResponseDTO marcarStatusDia(AgendaResponseDTO dto) {
        Optional<Prestador> prestador = prestadorRepository.findById(dto.getIdUsuario());
        if (!prestador.isPresent()) {
            throw new RuntimeException("Prestador não encontrado");
        }

        Optional<Agenda> agendaExistente = agendaRepository.findByPrestadorIdUsuarioAndDiaServico(dto.getIdUsuario(), dto.getDiaServico());

        if (agendaExistente.isPresent()) {
            Agenda agenda = agendaExistente.get();
            agenda.setHrDisponivel(dto.getHrDisponivel());
            agenda.setHrIndisponivel(dto.getHrIndisponivel());
            agenda.setStatusDia(dto.getStatusDia());

            Agenda agendaAtualizada = agendaRepository.save(agenda);
            return modelMapper.map(agendaAtualizada, AgendaResponseDTO.class);
        } else {
            Agenda novaAgenda = new Agenda();
            novaAgenda.setDiaServico(dto.getDiaServico());
            novaAgenda.setHrDisponivel(dto.getHrDisponivel());
            novaAgenda.setHrIndisponivel(dto.getHrIndisponivel());
            novaAgenda.setStatusDia(dto.getStatusDia());
            novaAgenda.setPrestador(prestador.get());

            Agenda agendaSalva = agendaRepository.save(novaAgenda);
            return modelMapper.map(agendaSalva, AgendaResponseDTO.class);
        }
    }
}
