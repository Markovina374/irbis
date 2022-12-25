package com.test.irbis.controller;

import com.test.irbis.model.News;
import com.test.irbis.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
  private final NewsService service;

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

  @GetMapping("/{id}")
  public ResponseEntity<News> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.readById(id));
  }

  @PutMapping
  public ResponseEntity<News> update(@RequestBody News news) throws Exception {
    return ResponseEntity.ok(service.update(news));
  }

  @PostMapping
  public ResponseEntity<News> create(@RequestBody News news) throws Exception {
    return ResponseEntity.ok(service.create(news));
  }

  @DeleteMapping
  public ResponseEntity<Boolean> delete(@RequestBody News news) {
    return ResponseEntity.ok(service.delete(news));
  }
}
