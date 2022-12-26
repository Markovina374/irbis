package com.test.irbis.service;

import com.test.irbis.auth.Enter;
import com.test.irbis.auth.JwtTokenService;
import com.test.irbis.auth.JwtUserDetailsService;
import com.test.irbis.auth.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final JwtTokenService jwtTokenService;
  private final JwtUserDetailsService jwtUserDetailsService;
  @Autowired
  private PasswordEncoder passwordEncoder;


  public Token getToken(Enter authenticationRequest) {
    final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getLogin());
    checkPassword(authenticationRequest, userDetails);
    return new Token(jwtTokenService.generateToken(userDetails));
  }

  private void checkPassword(Enter enter, UserDetails userDetails) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    if (!passwordEncoder.matches(enter.getPassword(), userDetails.getPassword())) {
      throw new UsernameNotFoundException("Неверный пароль");
    }
  }
}
