package com.test.irbis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Супер класс модели
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Model {
  /**
   * Идентификатор записи
   */
  @Id
  @Column(name = "ID")
  protected long id;
}
