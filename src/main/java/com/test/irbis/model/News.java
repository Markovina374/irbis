package com.test.irbis.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "NEWS")
@Data
public class News extends Model {

  @ManyToOne
  @JoinColumn(name = "TOPIC_ID")
  private Topic topic;

  private String text;
}
