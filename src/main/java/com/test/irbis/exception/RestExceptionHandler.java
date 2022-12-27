package com.test.irbis.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

/**
 * Обработчик ошибок балансодержателя. Заворачивает ошибку в объект
 */
@Slf4j
@ControllerAdvice()
public class RestExceptionHandler {

  @ExceptionHandler(NewsServiceException.class)
  protected <T extends NewsServiceException> ResponseEntity<ErrorResponse> exceptionHandler(T exception) {
    return new ResponseEntity<>(createErrorResponse(exception), exception.getHttpStatus());
  }

  @ExceptionHandler(SQLException.class)
  protected <T extends SQLException> ResponseEntity<ErrorResponse> exceptionHandler(T exception) {
    return new ResponseEntity<>(createErrorResponse(exception), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(DateTimeParseException.class)
  protected <T extends DateTimeParseException> ResponseEntity<ErrorResponse> exceptionHandler(T exception) {
    return new ResponseEntity<>(createErrorResponse(exception), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpMessageConversionException.class)
  protected <T extends HttpMessageConversionException> ResponseEntity<ErrorResponse> exceptionHandler(T exception) {
    return new ResponseEntity<>(createErrorResponse(exception), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ServletRequestBindingException.class)
  protected <T extends ServletRequestBindingException> ResponseEntity<ErrorResponse> exceptionHandler(T exception) {
    return new ResponseEntity<>(createErrorResponse(exception), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IOException.class)
  protected <T extends IOException> ResponseEntity<ErrorResponse> exceptionHandler(T exception) {
    return new ResponseEntity<>(createErrorResponse(exception), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpClientErrorException.class)
  protected <T extends HttpClientErrorException> ResponseEntity<ErrorResponse> exceptionHandler(T exception) {
    return new ResponseEntity<>(createErrorResponse(exception), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NullPointerException.class)
  protected <T extends NullPointerException> ResponseEntity<ErrorResponse> exceptionHandler(T exception) {
    return new ResponseEntity<>(createErrorResponse(exception), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Создание тела ответа
   *
   * @param ex ошибка
   * @return тело ответа с ошибкой
   */
  private ErrorResponse createErrorResponse(Exception ex) {
    ErrorResponse error = new ErrorResponse();
    error.setExceptionType(ex.getClass().getSimpleName());
    error.setMessage(ex.getMessage());
    log.error(String.format("User: %s Request returned with an error: ",
            SecurityContextHolder.getContext().getAuthentication().getName()),
            ex);
    return error;
  }
}
