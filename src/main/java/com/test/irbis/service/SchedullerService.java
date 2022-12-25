package com.test.irbis.service;

import com.test.irbis.model.Publisher;
import it.sauronsoftware.cron4j.Scheduler;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class SchedullerService {

  private final PublisherService publisherService;

  private final CSVService csvService;

  @PostConstruct
  private void start () {
    List<Publisher> publishersWithCron = publisherService.readAll()
            .stream()
            .filter(x -> !Objects.equals(x.getReportInterval(), ""))
            .toList();
    publishersWithCron.forEach(x -> {
      Scheduler scheduler = new Scheduler();
      scheduler.schedule(x.getReportInterval(), () -> csvService.writeLineByLine(x));
      scheduler.setDaemon(true);
      scheduler.start();
    });
  }


}
