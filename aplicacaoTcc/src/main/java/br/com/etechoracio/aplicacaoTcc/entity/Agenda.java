package br.com.etechoracio.aplicacaoTcc.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Table(name = "AGENDA")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AGENDA")
    private Integer idAgenda;

    @Column(name = "HR_DISPONIVEL")
    private LocalTime hrDisponivel;

    @Column(name = "HR_INDISPONIVEL")
    private LocalTime hrIndisponivel;

    @Column(name = "DIA_SERV")
    private LocalDate diaServico;

    @ManyToOne
    @JoinColumn(name = "ID_PRESTADOR")
    private Categoria idPres;
}
