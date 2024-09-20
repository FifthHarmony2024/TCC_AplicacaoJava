package br.com.etechoracio.aplicacaoTcc.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "CNPJ")
    public BigInteger cnpj;

    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postagem> postagens;


}
