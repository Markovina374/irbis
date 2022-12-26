package com.test.irbis.service;

import com.test.irbis.model.Publisher;
import com.test.irbis.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService extends CrudService<Publisher, PublisherRepository> {

  public PublisherService(PublisherRepository repository) {
    super(repository);
  }
}
