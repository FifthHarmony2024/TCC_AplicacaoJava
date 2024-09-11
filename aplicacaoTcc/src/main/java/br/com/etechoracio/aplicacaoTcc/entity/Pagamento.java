package br.com.etechoracio.aplicacaoTcc.entity;

import br.com.etechoracio.aplicacaoTcc.enuns.FormaPgto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PAGAMENTO")

public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PGTO")
    private Integer idPgto;

    @Column(name = "VALOR_TAXA")
    private Double  valorTaxa;

    @Column(name = "FORMA_PGTO")
    @Enumerated(EnumType.ORDINAL)
    private FormaPgto formaPgto;
}
