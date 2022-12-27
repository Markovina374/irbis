package com.test.irbis.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Ошибка базы данных(объект не найден).
 */
@Getter
@Setter
public class DbException extends NewsServiceException {

  /**
   * Конструктор
   *
   * @param message Сообщение об ошибке
   */
  public DbException(String message) {
    super(message, HttpStatus.NOT_FOUND);
  }

  /**
   * Конструктор с httpStatus
   *
   * @param message    сообщение с ошибкой
   * @param httpStatus статус запроса
   */
  public DbException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }
}
