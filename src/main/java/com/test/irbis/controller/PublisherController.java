package com.test.irbis.controller;

import com.test.irbis.model.Publisher;
import com.test.irbis.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController extends AbstractController<Publisher, PublisherService> {

  public PublisherController(PublisherService service) {
    super(service);
  }

  @GetMapping
  public ResponseEntity<List<Publisher>> getAllPublishers() {
    return ResponseEntity.ok(service.readAll());
  }

}
