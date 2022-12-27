package com.test.irbis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Тема новости
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table(name = "TOPICS")
@Data
public class Topic extends Model {
  /**
   * Описание темы
   */
  private String description;
  /**
   * Издатель темы
   */
  @ManyToOne
  @JoinColumn(name = "PUBLISHER_ID")
  private Publisher publisher;
}
