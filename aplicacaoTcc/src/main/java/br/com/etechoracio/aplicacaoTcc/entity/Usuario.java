package br.com.etechoracio.aplicacaoTcc.entity;

import br.com.etechoracio.aplicacaoTcc.enuns.GeneroOpcao;
import br.com.etechoracio.aplicacaoTcc.enuns.TipoPrestador;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "DATANASCIMENTO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "GENERO")
    @Enumerated(EnumType.ORDINAL)
    private GeneroOpcao generoOpcao;

    @Column(name = "CPF")
    private BigInteger cpf;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "N_RESIDENCIAL")
    private Integer numResidencial;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "COMPLEMENTORESI")
    private String complementoResi;

    @Column(name = "CEP")
    private BigInteger cep;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    private String confSenha;

}
