package br.com.etechoracio.aplicacaoTcc.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "AVALIACAO")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AVALIACAO")
    private Integer idAvaliacao;

    @Column(name = "COMENTARIOS")
    private String comentarios;

    @Column(name = "NOTA")
    private Integer nota;

    @Column(name = "DT_AVALIACAO")
    private LocalDate dtAvaliacao;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario idCli;

    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido idPed;

    @ManyToOne
    @JoinColumn(name = "ID_PRESTADOR")
    private Prestador idPres;

}
