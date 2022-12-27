package com.test.irbis.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NewsServiceException extends RuntimeException {

  private final HttpStatus httpStatus;

  protected NewsServiceException(String message) {
    this(message, HttpStatus.BAD_REQUEST);
  }

  protected NewsServiceException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }
}
