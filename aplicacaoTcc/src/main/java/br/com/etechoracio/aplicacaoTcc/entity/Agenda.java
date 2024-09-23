package br.com.etechoracio.aplicacaoTcc.entity;


import br.com.etechoracio.aplicacaoTcc.enuns.StatusDiaServico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
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

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_DIA")
    private StatusDiaServico statusDia;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Prestador prestador;

    @OneToMany
    private List<Pedido> pedidos;
}
