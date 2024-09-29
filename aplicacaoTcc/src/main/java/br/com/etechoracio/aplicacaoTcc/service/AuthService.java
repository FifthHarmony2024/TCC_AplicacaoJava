package br.com.etechoracio.aplicacaoTcc.service;

import br.com.etechoracio.aplicacaoTcc.dto.AcessResponseDTO;
import br.com.etechoracio.aplicacaoTcc.dto.AuthenticationResponseDTO;
import br.com.etechoracio.aplicacaoTcc.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticatioManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessResponseDTO login(AuthenticationResponseDTO authDto) {

        try {
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getSenha());

            Authentication authentication = authenticatioManager.authenticate(userAuth);

            UserDetailImpl userAuthenticate = (UserDetailImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessResponseDTO acessResponseDTO = new AcessResponseDTO(token);

            return acessResponseDTO;

        }catch(BadCredentialsException e) {
            //TODO LOGIN OU SENHA INVALIDO
        }
        return new AcessResponseDTO("Acesso negado");
    }
}
