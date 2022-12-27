package com.test.irbis.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Сервис для работы с токенами
 */
@Service
@Slf4j
public class JwtTokenService {

  private final Algorithm hmac512;
  private final JWTVerifier verifier;
  /**
   * Время жизни токена
   */
  private final int jwtTokenTimeValidity = 4 * 60 * 60 * 1000;

  public JwtTokenService(@Value("${jwt.secret}") final String secret) {
    this.hmac512 = Algorithm.HMAC512(secret);
    this.verifier = JWT.require(this.hmac512).build();
  }

  /**
   * Метод генерации токена
   */
  public String generateToken(final UserDetails userDetails) {
    return JWT.create()
            .withSubject(userDetails.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + jwtTokenTimeValidity))
            .sign(this.hmac512);
  }

  /**
   * Валидация токена и импорт от туда логина
   *
   * @param token строка токена
   * @return логин пользователя
   */
  public String validateTokenAndGetUsername(final String token) {
    try {
      return verifier.verify(token).getSubject();
    } catch (final JWTVerificationException verificationEx) {
      log.warn("token invalid: {}", verificationEx.getMessage());
      return null;
    }
  }

}
