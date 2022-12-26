package com.test.irbis.service;

import com.test.irbis.model.Topic;
import com.test.irbis.repository.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService extends CrudService<Topic, TopicRepository> {
  public TopicService(TopicRepository repository) {
    super(repository);
  }
}
