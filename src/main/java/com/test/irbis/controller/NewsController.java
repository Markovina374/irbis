package com.test.irbis.controller;

import com.test.irbis.model.News;
import com.test.irbis.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController extends AbstractController<News, NewsService> {

  public NewsController(NewsService service) {
    super(service);
  }

  @GetMapping
  public ResponseEntity<List<News>> getAllNews(
          @RequestParam(value = "page", required = false, defaultValue = "0") int page,
          @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
    return ResponseEntity.ok(service.readAll(page, size));
  }

  @GetMapping("/search")
  public ResponseEntity<List<News>> findByTopicOrPublisher(
          @RequestParam(value = "topicDescription", required = false, defaultValue = "") String topicDescription,
          @RequestParam(value = "publisherName", required = false, defaultValue = "") String publisherName,
          @RequestParam(value = "page", required = false, defaultValue = "1") int page,
          @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
    return ResponseEntity.ok(service.findNews(topicDescription, publisherName, page, size));
  }
}
