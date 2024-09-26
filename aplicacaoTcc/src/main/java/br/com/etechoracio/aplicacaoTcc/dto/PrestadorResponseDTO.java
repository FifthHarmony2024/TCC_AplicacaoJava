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
    private BigInteger cnpj;
    private TipoPrestador tipo;
    private List<PostagemResponseDTO> postagens;

    // fica aparecendo o cnpj no get, fazer nao aparecer 
    public BigInteger getDocumento() {
        if (TipoPrestador.MICROEMPREENDEDOR.equals(tipo)) {
            return cnpj;
        } else{
            return null;
        }
    }

}
