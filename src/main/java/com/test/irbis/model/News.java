package com.test.irbis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Новость
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table(name = "NEWS")
@Data
public class News extends Model {
  /**
   * Тема новости
   */
  @ManyToOne
  @JoinColumn(name = "TOPIC_ID")
  private Topic topic;
  /**
   * Текст новости
   */
  private String text;
}
