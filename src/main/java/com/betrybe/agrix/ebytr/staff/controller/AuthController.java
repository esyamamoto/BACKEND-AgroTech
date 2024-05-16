package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.AuthDto;
import com.betrybe.agrix.ebytr.staff.dto.TokenDto;
import com.betrybe.agrix.ebytr.staff.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável por lidar com autenticação e geração de tokens.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  /**
   * Construtor que inicializa o gerenciador de autenticação e o serviço de tokens.
   *
   * @param authenticationManager gerenciador de autenticação usado para autenticar credenciais.
   * @param tokenService serviço responsável pela geração e validação de tokens JWT.
   */
  @Autowired
  public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  /**
   * Endpoint para login de usuários. Autentica as credenciais e gera um token JWT.
   *
   * @param authDto objeto contendo as credenciais de autenticação (username e password).
   * @return um objeto TokenDto contendo o token JWT.
   */
  @PostMapping("/login")
  public TokenDto login(@RequestBody AuthDto authDto) {
    UsernamePasswordAuthenticationToken usernamePassword =
        new UsernamePasswordAuthenticationToken(
            authDto.username(),
            authDto.password()
        );

    // verifica se ta tudo certo com as credenciais
    Authentication auth = authenticationManager.authenticate(usernamePassword);
    // gera token
    String token = tokenService.generateToken(auth.getName());

    return new TokenDto(token);
  }
}
