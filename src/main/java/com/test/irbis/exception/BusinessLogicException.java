package com.test.irbis.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Ошибка БизнесЛогики
 */
@Getter
@Setter
public class BusinessLogicException extends NewsServiceException {

    /**
     * Конструктор
     *
     * @param message Сообщение об ошибке
     */
    public BusinessLogicException(String message) {
        super(message);
    }

    /**
     * Конструктор с httpStatus
     *
     * @param message    сообщение с ошибкой
     * @param httpStatus статус запроса
     */
    public BusinessLogicException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
