package com.test.irbis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PUBLISHERS")
@Data
public class Publisher extends Model {
  private String name;
  @JsonIgnore
  @Column(name = "REPORT_INTERVAL")
  private String reportInterval;
}
