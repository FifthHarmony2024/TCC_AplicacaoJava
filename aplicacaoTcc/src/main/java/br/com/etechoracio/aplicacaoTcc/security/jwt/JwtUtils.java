package br.com.etechoracio.aplicacaoTcc.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    @Value("${aplicacao.jwtSecret}")
    private String jwtSecret;

    private int jwtExpirationMs; // quanto tempo ficar válido meu Token
}
