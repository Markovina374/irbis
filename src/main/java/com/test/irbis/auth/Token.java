package com.test.irbis.auth;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Токен авторизации
 */
@Data
@RequiredArgsConstructor
public class Token {
  private final String accessToken;
}
