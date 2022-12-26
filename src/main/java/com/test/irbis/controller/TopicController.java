package com.test.irbis.controller;

import com.test.irbis.model.Topic;
import com.test.irbis.service.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController extends AbstractController<Topic, TopicService> {

  public TopicController(TopicService service) {
    super(service);
  }

  @GetMapping
  public ResponseEntity<List<Topic>> getAllTopics() {
    return ResponseEntity.ok(service.readAll());
  }


}
