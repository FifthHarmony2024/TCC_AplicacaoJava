package br.com.etechoracio.aplicacaoTcc.entity;

import br.com.etechoracio.aplicacaoTcc.enuns.TipoPrestador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRESTADOR")
public class Prestador extends Usuario {

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria categoriaServico;

    @Column(name = "NOME_COMERCIAL")
    private String nomeComercial;

    @CNPJ
    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "TIPO_PRESTADOR")
    @Enumerated(EnumType.ORDINAL)
    private TipoPrestador tipoPrestador;

    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postagem> postagens;

    @ManyToMany
    @JoinTable(
            name = "PRESTADOR_CATEGORIA",
            joinColumns = @JoinColumn(name = "ID_PRESTADOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_CATEGORIA")
    )
    private List<Categoria> categorias;

}
