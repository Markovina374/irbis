package com.test.irbis.controller;

import com.test.irbis.model.Model;
import com.test.irbis.model.News;
import com.test.irbis.service.NewsService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для работы с новостями
 */
@Tag(name = "News", description = "The news controller")
@RestController
@RequestMapping("/news")
public class NewsController extends AbstractController<News, NewsService> {

  public NewsController(NewsService service) {
    super(service);
  }

  /**
   * Получение всех новостей с пагинацией
   *
   * @param page номер страницы
   * @param size размер по сколько выводить на страницу
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
  public ResponseEntity<List<News>> getAllNews(
          @RequestParam(value = "page", required = false, defaultValue = "0") int page,
          @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
    return ResponseEntity.ok(service.readAll(page, size));
  }

  /**
   * Поиск по темам с пагинацией
   *
   * @param topicDescription описание новости
   * @param page             номер страницы
   * @param size             размер по сколько выводить на страницу
   * @return
   */
  @GetMapping("/search/topic")
  @Operation(summary = "Find by topic description", tags = "findByTopic")
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
  public ResponseEntity<List<News>> findByTopicDescription(
          @RequestParam(value = "topicDescription", required = false, defaultValue = "") String topicDescription,
          @RequestParam(value = "page", required = false, defaultValue = "1") int page,
          @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
    return ResponseEntity.ok(service.findNewsByTopicDescription(topicDescription, page, size));
  }

  /**
   * Поиск по источнику
   *
   * @param publisherName наименование источника
   * @param page          номер страницы
   * @param size          размер по сколько выводить на страницу
   */
  @GetMapping("/search/source")
  @Operation(summary = "Find by publisher name", tags = "findByPublisher")
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
  public ResponseEntity<List<News>> findByPublisherName(
          @RequestParam(value = "publisherName", required = false, defaultValue = "") String publisherName,
          @RequestParam(value = "page", required = false, defaultValue = "1") int page,
          @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
    return ResponseEntity.ok(service.findNewsByPublisherName(publisherName, page, size));
  }
}
