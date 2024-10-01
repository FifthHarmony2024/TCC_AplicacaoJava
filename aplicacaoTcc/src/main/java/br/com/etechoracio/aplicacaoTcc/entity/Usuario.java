package br.com.etechoracio.aplicacaoTcc.entity;

import br.com.etechoracio.aplicacaoTcc.enuns.GeneroOpcao;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

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

    @NotBlank // preenchdio e nao espaco em branco
    // FAZER VALIDACAO DE IR MAIUSCULA NO FORNT
    @Pattern(regexp = "^[A-Z]+(.)*") // PRIMEIRA LETRA SEMPRE SERA MAIUSCULA
    @Column(name = "NOME")
    private String nome;

    @NotBlank
    @Pattern(regexp = "^[A-Z]+(.)*")
    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "DATANASCIMENTO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank
    @Column(name = "SENHA")
    private String senha;

    @Column(name = "GENERO")
    @Enumerated(EnumType.ORDINAL)
    private GeneroOpcao generoOpcao;

    @CPF
    @Column(name = "CPF")
    private String cpf;

    @NotBlank
    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "N_RESIDENCIAL")
    private Integer numResidencial;

    @NotBlank
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

    @NotBlank
    private String confSenha;

    @Column(unique = true)
    private String login;

    private String fotoPerfil;

}
