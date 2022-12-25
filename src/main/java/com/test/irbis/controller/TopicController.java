package com.test.irbis.controller;

import com.test.irbis.model.Topic;
import com.test.irbis.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {
  private final TopicService service;

  @GetMapping
  public ResponseEntity<List<Topic>> getAllTopics() {
    return ResponseEntity.ok(service.readAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Topic> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.readById(id));
  }

  @PutMapping
  public ResponseEntity<Topic> update(@RequestBody Topic topic) throws Exception {
    return ResponseEntity.ok(service.update(topic));
  }

  @PostMapping
  public ResponseEntity<Topic> create(@RequestBody Topic topic) throws Exception {
    return ResponseEntity.ok(service.create(topic));
  }

  @DeleteMapping
  public ResponseEntity<Boolean> delete(@RequestBody Topic topic) {
    return ResponseEntity.ok(service.delete(topic));
  }
}
