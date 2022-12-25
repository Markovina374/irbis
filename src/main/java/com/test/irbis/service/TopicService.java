package com.test.irbis.service;

import com.test.irbis.model.Topic;
import com.test.irbis.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopicService extends CrudService<Topic>{

  public TopicService(JpaRepository<Topic, Long> repository) {
    super(repository);
  }
}
