package br.com.etechoracio.aplicacaoTcc.entity;

import br.com.etechoracio.aplicacaoTcc.enuns.FormaPgto;
import br.com.etechoracio.aplicacaoTcc.enuns.TipoPrestador;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRESTADOR")

public class Prestador extends Usuario{

    @Column(name = "CATEGORIA_SERVICO")
    public String categoriaServico;

    @Column(name = "NOME_COMERCIAL")
    public String nomeComercial;

    @CNPJ
    @Column(name = "CNPJ")
    public String cnpj;

    @Column(name = "TIPO_PRESTADOR")
    @Enumerated(EnumType.ORDINAL)
    private TipoPrestador tipoPrestador;

    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postagem> postagens;



}
