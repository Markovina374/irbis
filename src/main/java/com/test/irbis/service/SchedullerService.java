package com.test.irbis.service;

import it.sauronsoftware.cron4j.Scheduler;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с планировщикам задач
 */
@RequiredArgsConstructor
@Service
public class SchedullerService {
  /**
   * Сервис источников
   */
  private final PublisherService publisherService;
  /**
   * Сервис для работы с таблицами
   */
  private final CSVService csvService;

  /**
   * Метод ищет все источники - у которых есть выражения крон,
   * запускает независимых друг от друга планировщиков по ним,
   * для создания отчётов
   */
  @PostConstruct
  private void start() {
    publisherService.readAll()
            .stream()
            .filter(x -> x.getReportInterval() != null && !x.getReportInterval().equals(""))
            .forEach(x -> {
              Scheduler scheduler = new Scheduler();
              scheduler.schedule(x.getReportInterval(), () -> csvService.writeLineByLine(x));
              scheduler.setDaemon(true);
              scheduler.start();
            });
  }


}
