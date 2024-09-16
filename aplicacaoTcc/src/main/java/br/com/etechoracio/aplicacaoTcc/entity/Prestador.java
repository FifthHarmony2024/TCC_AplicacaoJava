package br.com.etechoracio.aplicacaoTcc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

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


}
