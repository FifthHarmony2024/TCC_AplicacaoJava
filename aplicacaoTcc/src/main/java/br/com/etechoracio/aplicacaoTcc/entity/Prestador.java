package br.com.etechoracio.aplicacaoTcc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Entity

public class Prestador extends Usuario{
    @Column(name = "CATEGORIA_SERVICO")
    private String categoriaServico;

    @Column(name = "NOME_COMERCIAL")
    private String nomeComercial;

    @Column(name = "CNPJ")
    private BigInteger cnpj;
}
