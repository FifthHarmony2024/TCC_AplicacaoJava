package br.com.etechoracio.aplicacaoTcc.dto;

import br.com.etechoracio.aplicacaoTcc.entity.Postagem;
import br.com.etechoracio.aplicacaoTcc.enuns.TipoPrestador;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class PrestadorResponseDTO extends UsuarioResponseDTO{

    private String nomeComercial;
    private String categoriaServico;
    private String cnpj;
    private TipoPrestador tipo;
    private String cpf;
    private List<PostagemResponseDTO> postagens;

    public String getDocumento() {
        if (TipoPrestador.MICROEMPREENDEDOR.equals(tipo)) {
            return cnpj;
        } else if (TipoPrestador.AUTONOMO.equals(tipo)) {
            return cpf;
        } else {
            return null;
        }
    }

}
