package com.test.irbis.service;

import com.opencsv.CSVWriter;
import com.test.irbis.model.News;
import com.test.irbis.model.Publisher;
import com.test.irbis.model.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CSVService {

  private final NewsService newsService;

  @Value("${reportPath}")
  private String pathForReport;

  public void writeLineByLine(Publisher publisher) {
    try (CSVWriter writer = new CSVWriter(new FileWriter(pathForReport + publisher.getName() + ".csv"))) {
      for (String[] line :  getLinesForReportByPublisherId(publisher.getId())) {
        writer.writeNext(line);
      }
    }catch (Exception exception){
       exception.printStackTrace();
    }
  }

  List<String[]> getLinesForReportByPublisherId(Long publisherId) {
    Map<String, Long> map = newsService.findAllByPublisherId(publisherId).stream().collect(
            Collectors.groupingBy(x -> x.getTopic().getDescription(), Collectors.counting()));
    return map.entrySet().stream().map(x -> new String[]{x.getKey(), x.getValue().toString()}).toList();
  }


}
