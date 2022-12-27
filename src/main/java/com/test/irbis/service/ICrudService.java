package com.test.irbis.service;

import com.test.irbis.exception.DbException;
import com.test.irbis.model.Model;

import java.util.List;

/**
 * Круд интерфейс
 */
public interface ICrudService<E extends Model> {
  E create(E element) throws DbException;

  boolean isElementExist(E element);

  List<E> readAll();

  E readById(Long id);

  E update(E element) throws DbException;

  boolean delete(Long elementId) throws DbException;
}
