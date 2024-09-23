package br.com.etechoracio.aplicacaoTcc.dto;

import br.com.etechoracio.aplicacaoTcc.enuns.StatusDiaServico;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class AgendaResponseDTO {

    private LocalDate diaServico;
    private LocalTime hrDisponivel;
    private LocalTime hrIndisponivel;
    private StatusDiaServico statusDia;
    private Integer idUsuario;

  //  private List<PedidosResponseDTO> pedidos;

}
