package com.test.irbis.controller;

import com.test.irbis.auth.Enter;
import com.test.irbis.auth.Token;
import com.test.irbis.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер Аунтификации
 */
@Tag(name = "Authentication", description = "The authentication API")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService service;

  /**
   * Получить jwt токен
   */
  @Operation(summary = "Get token for authentication", tags = "token")
  @ApiResponses(value = {
          @ApiResponse(
                  responseCode = "200",
                  description = "accessToken",
                  content = {
                          @Content(
                                  mediaType = "application/json",
                                  array = @ArraySchema(schema = @Schema(implementation = Token.class)))
                  })
  })
  @PostMapping("/token")
  public ResponseEntity<Token> authenticate(@Parameter(name = "Enter") @RequestBody Enter authenticationRequest) {
    return ResponseEntity.ok(service.getToken(authenticationRequest));
  }
}