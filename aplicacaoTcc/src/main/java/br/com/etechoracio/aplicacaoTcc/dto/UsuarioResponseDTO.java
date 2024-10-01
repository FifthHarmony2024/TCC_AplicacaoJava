package br.com.etechoracio.aplicacaoTcc.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioResponseDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String estado;
    private String cidade;
    private String fotoPerfil;

}
