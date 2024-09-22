package br.com.etechoracio.aplicacaoTcc.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "SEXO")
    private char sexo;

    @Column(name = "DATANASCIMENTO")
    private LocalDate dataNascimento;

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

    private String confSenha;

}
