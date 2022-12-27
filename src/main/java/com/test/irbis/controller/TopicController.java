package com.test.irbis.controller;

import com.test.irbis.model.Model;
import com.test.irbis.model.Topic;
import com.test.irbis.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для работы с темами
 */
@Tag(name = "Topic", description = "The topic controller")
@RestController
@RequestMapping("/topics")
public class TopicController extends AbstractController<Topic, TopicService> {

  public TopicController(TopicService service) {
    super(service);
  }

  /**
   * Получить все темы
   */
  @GetMapping
  @Operation(summary = "Get all", tags = "getAll")
  @ApiResponses(value = {
          @ApiResponse(
                  responseCode = "200",
                  description = "OK",
                  content = {@Content(
                          mediaType = MediaType.APPLICATION_JSON_VALUE,
                          schema = @Schema(implementation = Model.class))}),
          @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
          @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
          @ApiResponse(responseCode = "404", description = "Объект не найден", content = @Content)})
  public ResponseEntity<List<Topic>> getAllTopics() {
    return ResponseEntity.ok(service.readAll());
  }


}
