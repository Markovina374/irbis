package com.test.irbis.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TOPICS")
@Data
public class Topic extends Model {

  private String description;
  @ManyToOne
  @JoinColumn(name = "PUBLISHER_ID")
  private Publisher publisher;
}
