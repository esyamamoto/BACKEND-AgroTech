package com.betrybe.agrix.ebytr.staff.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por operações relacionadas a tokens JWT, incluindo a geração e validação.
 */
@Service
public class TokenService {
  private final Algorithm algorithm;

  /**
   * Construtor do TokenService que inicializa o algoritmo HMAC256 com um segredo fornecido.
   * segredo utilizado para assinar os tokens.
   */
  public TokenService(@Value("${api.security.token.secret}") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * Gera um token JWT para um determinado usuário.
   *
   * @param username nome de usuário para o qual o token será gerado.
   *
   * @return o token JWT gerado.
   */
  public String generateToken(String username) {
    return JWT.create()
        .withSubject(username)
        .withExpiresAt(generateExpiration())
        .sign(algorithm);
  }

  /**
   * Gera uma data de expiração para o token.
   *
   * @return um objeto Instant representando a data de expiração (2h a partir do momento atual).
   */
  private Instant generateExpiration() {
    return Instant.now()
        .plus(2, ChronoUnit.HOURS);
  }

  /**
   * Valida um tokenJWT e retorna username.
   *
   * @param token o token JWT a ser validado.
   * @return o nome de usuário associado ao token se a validação for bem-sucedida.
   */
  public String validateToken(String token) {
    return JWT.require(algorithm)
        .build()
        .verify(token)
        .getSubject();
  }
}
