package br.com.etechoracio.aplicacaoTcc.dto;


import lombok.Data;
import lombok.Getter;

@Data
public class AuthenticationResponseDTO {

    private String email;
    private String senha;

}
