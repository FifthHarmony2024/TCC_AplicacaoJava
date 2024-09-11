package br.com.etechoracio.aplicacaoTcc.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Table(name = "DATA_AGENDA")
public class DataAgenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DTAGENDA")
    private Integer idDtAgenda;

    @Column(name = "DT_SERV")
    private LocalDate dtServico;

    @Column(name = "HR_SERV")
    private LocalTime hrServico;
}
