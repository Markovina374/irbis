package com.test.irbis.repository;

import com.test.irbis.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
  Page<News> findAll(Pageable pageable);
  Page<News> findAllByTopic_DescriptionOrTopicPublisherName(String description, String publisherName, PageRequest pageable);

  List<News> findAllByTopic_PublisherId(Long publisherId);
}
