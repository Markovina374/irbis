package com.test.irbis.repository;

import com.test.irbis.model.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для работы с пользователями
 */
@Repository
public interface UserRepository extends JpaRepository<WebUser, Long> {
  /**
   * Поиск по логину
   *
   * @param login логин пользователя
   */
  Optional<WebUser> findByLogin(String login);
}
