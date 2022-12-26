package com.test.irbis.controller;

import com.test.irbis.auth.Enter;
import com.test.irbis.auth.Token;
import com.test.irbis.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService service;

  @PostMapping("/token")
  public ResponseEntity<Token> authenticate(@RequestBody Enter authenticationRequest) {
    return ResponseEntity.ok(service.getToken(authenticationRequest));
  }
}