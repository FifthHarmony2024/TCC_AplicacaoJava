package br.com.etechoracio.aplicacaoTcc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "AGENDAMENTO")
public class Agendamento {

    @Id
    @Column(name = "ID_AGENDAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgendamento;

    @Column(name = "DT_AGENDAMENTO")
    private LocalDateTime dataAgendamento;

    @Column(name = "HR_AGENDAMENTO")
    private LocalTime hrAgendamento;

    @Column(name = "VL_ORC")
    private BigDecimal valorOrcamento;

}
