package com.test.irbis.service;

import com.test.irbis.auth.Enter;
import com.test.irbis.auth.JwtTokenService;
import com.test.irbis.auth.JwtUserDetailsService;
import com.test.irbis.auth.Token;
import com.test.irbis.exception.BusinessLogicException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Сервис авторизации
 */
@Service
@RequiredArgsConstructor
public class AuthService {
  /**
   * Токен сервис
   */
  private final JwtTokenService jwtTokenService;
  /**
   * Реализация UserDetailServiс'а
   */
  private final JwtUserDetailsService jwtUserDetailsService;
  /**
   * Шифратор паролей
   */
  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * Метод получения токена
   *
   * @param authenticationRequest запрос на аторизацию
   */
  public Token getToken(Enter authenticationRequest) {
    final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getLogin());
    checkPassword(authenticationRequest, userDetails);
    return new Token(jwtTokenService.generateToken(userDetails));
  }

  /**
   * Метод проверки пароля
   */
  private void checkPassword(Enter enter, UserDetails userDetails) {
    if (!passwordEncoder.matches(enter.getPassword(), userDetails.getPassword())) {
      throw new BusinessLogicException("Incorrect password", HttpStatus.UNAUTHORIZED);
    }
  }
}
