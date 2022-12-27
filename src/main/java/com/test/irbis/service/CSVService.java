package com.test.irbis.service;

import com.opencsv.CSVWriter;
import com.test.irbis.model.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Сервис работы с таблицами отчётов
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CSVService {
  /**
   * Сервис новостей
   */
  private final NewsService newsService;
  /**
   * Путь до папки куда будут сохраняться отчёты
   */
  @Value("${reportPath}")
  private String pathForReport;

  /**
   * Запись отчёта в файл
   */
  public void writeLineByLine(Publisher publisher) {
    try (CSVWriter writer = new CSVWriter(new FileWriter(pathForReport + publisher.getName() + ".csv"))) {
      getLinesForReportByPublisherId(publisher.getId()).forEach(writer::writeNext);
    } catch (RuntimeException | IOException exception) {
      log.warn(exception.getMessage());
      exception.printStackTrace();
    }
  }

  /**
   * Метод подготовки объектов к записи в файл отчёта
   */
  List<String[]> getLinesForReportByPublisherId(Long publisherId) {
    Map<String, Long> map = newsService.findAllByPublisherId(publisherId).stream().collect(
            Collectors.groupingBy(x -> x.getTopic().getDescription(), Collectors.counting()));
    return map.entrySet().stream().map(x -> new String[]{x.getKey(), x.getValue().toString()}).toList();
  }
}
