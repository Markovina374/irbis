package com.test.irbis.repository;

import com.test.irbis.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Новостной репозиторий
 */
@Repository
public interface NewsRepository extends AbstractRepository<News> {
  /**
   * Найти все новости с пагинацией
   */
  Page<News> findAll(Pageable pageable);

  /**
   * Поиск новостей по описанию темы с пагинацией
   *
   * @param description кусок описания темы (не чувствительно к регистру)
   */
  Page<News> findAllByTopic_DescriptionContainingIgnoreCase(String description, Pageable pageable);

  /**
   * Поиск новостей по наименованию издателя с пагинацией
   *
   * @param publisherName кусок наименования источника темы (не чувствительно к регистру)
   */
  Page<News> findAllByTopic_PublisherNameContainingIgnoreCase(String publisherName, Pageable pageable);

  /**
   * Поиск по идентификатору источника
   *
   * @param publisherId идентификатор источника
   */
  List<News> findAllByTopic_PublisherId(Long publisherId);
}
