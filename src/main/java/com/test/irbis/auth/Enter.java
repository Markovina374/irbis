package com.test.irbis.auth;

import lombok.Data;

/**
 * Объект входа
 */
@Data
public class Enter {
  /**
   * Логин
   */
  private String login;
  /**
   * Пароль
   */
  private String password;
}
