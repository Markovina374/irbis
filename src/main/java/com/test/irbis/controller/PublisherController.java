package com.test.irbis.controller;

import com.test.irbis.model.Publisher;
import com.test.irbis.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {
  private final PublisherService service;

  @GetMapping
  public ResponseEntity<List<Publisher>> getAllPublishers() {
    return ResponseEntity.ok(service.readAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Publisher> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.readById(id));
  }

  @PutMapping
  public ResponseEntity<Publisher> update(@RequestBody Publisher publisher) throws Exception {
    return ResponseEntity.ok(service.update(publisher));
  }

  @PostMapping
  public ResponseEntity<Publisher> create(@RequestBody Publisher publisher) throws Exception {
    return ResponseEntity.ok(service.create(publisher));
  }

  @DeleteMapping
  public ResponseEntity<Boolean> delete(@RequestBody Publisher publisher) {
    return ResponseEntity.ok(service.delete(publisher));
  }
}
