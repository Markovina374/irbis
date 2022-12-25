package com.test.irbis.service;

import com.test.irbis.model.Publisher;
import com.test.irbis.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService extends CrudService<Publisher>{

  public PublisherService(JpaRepository<Publisher, Long> repository) {
    super(repository);
  }
}
