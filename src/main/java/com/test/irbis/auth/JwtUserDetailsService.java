package com.test.irbis.auth;


import com.test.irbis.model.WebUser;
import com.test.irbis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

  public static final String USER = "USER";
  public static final String ROLE_USER = "ROLE_" + USER;
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(final String username) {
    final WebUser client = userRepository.findByLogin(username).orElseThrow(
            () -> new UsernameNotFoundException("Пользователь с таким " + username + " не найден"));
    return new User(username, client.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(ROLE_USER)));
  }
}
