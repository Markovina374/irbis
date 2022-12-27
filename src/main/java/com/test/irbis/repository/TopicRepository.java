package com.test.irbis.repository;

import com.test.irbis.model.Topic;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с Темами новостей
 */
@Repository
public interface TopicRepository extends AbstractRepository<Topic> {
}
