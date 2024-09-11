package br.com.etechoracio.aplicacaoTcc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CONTRATO")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTRATO")
    private Integer idContrato;

    @Column(name = "PER_TAXA")
    private Double porceTaxa;

    @ManyToOne
    @JoinColumn(name = "ID_PGTO")
    private Pagamento idPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_PRESTADOR")
    private Prestador idPre;

}
