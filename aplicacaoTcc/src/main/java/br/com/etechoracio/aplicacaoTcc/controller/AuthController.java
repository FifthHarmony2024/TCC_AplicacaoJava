package br.com.etechoracio.aplicacaoTcc.controller;

import br.com.etechoracio.aplicacaoTcc.dto.AuthenticationResponseDTO;
import br.com.etechoracio.aplicacaoTcc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationResponseDTO authenticationResponseDTO){
        return ResponseEntity.ok(authService.login(authenticationResponseDTO));
    }

}
