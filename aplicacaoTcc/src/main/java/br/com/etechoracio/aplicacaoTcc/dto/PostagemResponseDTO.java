package br.com.etechoracio.aplicacaoTcc.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PostagemResponseDTO {

    private Integer idPostagem;
    private String url;
    private String descricaoPost;
    private String resolucao;
    private BigDecimal tamanhoArquivo;
    private String tipoArquivo;
    private LocalDate dtPostagem;
}
