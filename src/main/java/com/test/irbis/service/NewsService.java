package com.test.irbis.service;

import com.test.irbis.model.News;
import com.test.irbis.repository.NewsRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для работы с новостями
 */
@Service
public class NewsService extends CrudService<News, NewsRepository> {

  public NewsService(NewsRepository repository) {
    super(repository);
  }

  /**
   * Поиск новостей по теме новости с пагинацией
   */
  public List<News> findNewsByTopicDescription(String topicDescription, int page, int size) {
    return repository.findAllByTopic_DescriptionContainingIgnoreCase(topicDescription, PageRequest.of(page == 0 ? page : page - 1, size))
            .getContent();
  }

  /**
   * Поиск новостей по наименованию источника с пагинацией
   */
  public List<News> findNewsByPublisherName(String publisherName, int page, int size) {
    return repository.findAllByTopic_PublisherNameContainingIgnoreCase(publisherName, PageRequest.of(page == 0 ? page : page - 1, size))
            .getContent();

  }

  /**
   * Поиск всех с пагинацией
   */
  public List<News> readAll(int page, int size) {
    return repository.findAll(PageRequest.of(page == 0 ? page : page - 1, size))
            .getContent();
  }

  /**
   * Поиск по идентификатору источника
   */
  public List<News> findAllByPublisherId(Long id) {
    return repository.findAllByTopic_PublisherId(id);
  }
}
