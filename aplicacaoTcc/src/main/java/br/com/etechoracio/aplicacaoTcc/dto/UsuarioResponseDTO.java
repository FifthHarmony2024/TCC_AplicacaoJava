package br.com.etechoracio.aplicacaoTcc.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private Integer telefone;
    private String endereco;
}
