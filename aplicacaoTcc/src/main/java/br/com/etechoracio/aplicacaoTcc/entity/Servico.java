package br.com.etechoracio.aplicacaoTcc.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SERVICO")

public class Servico {
    @Id
    @Column(name = "ID_SERV")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServico;

    @Column(name = "NOME_SERVICO")
    private String nomeServico;

    @Column(name = "DESCRICAO_SERVICO")
    private String descricaoServico;

    @ManyToOne
    @JoinColumn(name = "ID_PRESTADOR")
    private Prestador id;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria idCate;

    @ManyToMany
    @JoinTable(name = " REL_PRESTADOR_SERVICO",
            joinColumns = @JoinColumn(name = "ID_SERV"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRESTADOR")
    )
    private List<Servico> servicos;

}
