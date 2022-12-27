package com.test.irbis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Пользователь
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "USERS")
public class WebUser extends Model {
  /**
   * Логин пользователя
   */
  private String login;
  /**
   * Пароль
   */
  private String password;
}
