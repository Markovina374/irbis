package com.test.irbis.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Ответ с ошибкой
 */
@Data
class ErrorResponse {
    /**
     * Класс исключения.
     */
    private String exceptionType;
    /**
     * Корневое сообщение об ошибке
     */
    private String message;

    /**
     * Стектрейс
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String stacktrace;
}
