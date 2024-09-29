package br.com.etechoracio.aplicacaoTcc.dto;

import lombok.Data;

import java.util.List;

@Data
public class AcessResponseDTO {

    private String token;

    //TODO implementar retornar o usuario e liberacoes (authorities)

    public AcessResponseDTO(String token) {
        super();
        this.token = token;
    }


}
