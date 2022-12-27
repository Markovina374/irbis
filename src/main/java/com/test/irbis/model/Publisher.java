package com.test.irbis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Издатель(Источник)
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table(name = "PUBLISHERS")
@Data
public class Publisher extends Model {
  /**
   * Наименование источника
   */
  private String name;
  /**
   * Крон выражение для записи отчёта
   */
  @Column(name = "REPORT_INTERVAL")
  private String reportInterval;
}
