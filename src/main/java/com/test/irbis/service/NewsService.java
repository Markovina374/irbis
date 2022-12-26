package com.test.irbis.service;

import com.test.irbis.model.News;
import com.test.irbis.repository.NewsRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService extends CrudService<News, NewsRepository> {

  public NewsService(NewsRepository repository) {
    super(repository);
  }

  public List<News> findNews(String topicDescription, String publisherName, int page, int size) {
    return repository.findAllByTopic_DescriptionOrTopicPublisherName(
            topicDescription, publisherName,
            PageRequest.of(page == 0 ? page : page - 1, size))
            .getContent();
  }

  public List<News> readAll(int page, int size) {
    return repository.findAll(PageRequest.of(page == 0 ? page : page - 1, size))
            .getContent();
  }

  public List<News> findAllByPublisherId(Long id) {
    return repository.findAllByTopic_PublisherId(id);
  }
}
