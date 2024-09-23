package br.com.etechoracio.aplicacaoTcc.controller;

import br.com.etechoracio.aplicacaoTcc.dto.AgendaResponseDTO;
import br.com.etechoracio.aplicacaoTcc.service.AgendaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping("/prestador/{idUsuario}")
    public List<AgendaResponseDTO> listarAgendasPorPrestador(@PathVariable Integer idUsuario) {
        return agendaService.listarAgendasPorPrestador(idUsuario);
    }

    @PostMapping("/marcar")
    public AgendaResponseDTO marcarStatusDia(@RequestBody AgendaResponseDTO dto) {
        return agendaService.marcarStatusDia(dto);
    }
}
