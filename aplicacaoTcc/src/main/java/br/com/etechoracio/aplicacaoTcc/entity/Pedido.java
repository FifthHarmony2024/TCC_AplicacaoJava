package br.com.etechoracio.aplicacaoTcc.entity;

import br.com.etechoracio.aplicacaoTcc.enuns.StatusServico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PEDIDO")
public class Pedido {
    @Id
    @Column(name = "ID_PEDIDO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column(name = "STATUS_SERVICO")
    @Enumerated(EnumType.ORDINAL)
    private StatusServico statusServico;

    @Column(name = "CATEGORIA_PEDIDO")
    private String categoriaPedido;

    @Column(name = "DESCRICAO_PEDIDO")
    private String descricao_Pedido;

    @ManyToOne
    @JoinColumn(name = "ID_AGENDAMENTO")
    private Agendamento idAge;

    @ManyToOne
    @JoinColumn(name = "HR_AGENDAMENTO")
    private Agendamento hrAgen;

    @ManyToOne
    @JoinColumn(name = "DT_AGENDAMENTO")
    private Agendamento dataAge;

    @ManyToOne
    @JoinColumn(name = "ID_PRESTADOR")
    private Prestador idPres;

    @ManyToOne
    @JoinColumn(name = "VL_ORC")
    private Agendamento valorOrcamento;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario idCLi;
}
