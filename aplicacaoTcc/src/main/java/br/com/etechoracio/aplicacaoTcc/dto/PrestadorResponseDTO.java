package br.com.etechoracio.aplicacaoTcc.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PrestadorResponseDTO extends UsuarioResponseDTO{
    private String nomeComercial;
    private String categoriaServico;
    private BigInteger cnpj;
}
