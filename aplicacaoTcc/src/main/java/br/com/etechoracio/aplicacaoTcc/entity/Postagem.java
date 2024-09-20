package br.com.etechoracio.aplicacaoTcc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "POSTAGEM")
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_POSTAGEM")
    private Integer idPostagem;

    @Column(name = "URL")
    private String url;

    @Column(name = "DESCRICAO_POST")
    private String descricaoPost;

    @Column(name = "RESOLUCAO")
    private String resolucao;

    @Column(name = "TAMANHO_ARQUIVO")
    private BigDecimal tamanhoArquivo;

    @Column(name = "TIPO_ARQUIVO")
    private String tipoArquivo;

    @Column(name = "DT_POSTAGEM")
    private LocalDate dtPostagem;

    @ManyToOne
    @JoinColumn(name = "ID_PRESTADOR", nullable = false)
    private Prestador prestador;
}
