package com.test.irbis.service;

import com.test.irbis.model.Model;

import java.util.List;

public interface ICrudService<E extends Model> {
  E create(E element) throws Exception;

  boolean isElementExist(E element);

  List<E> readAll();

  E readById(Long id);

  E update(E element) throws Exception;

  boolean delete(E element);
}
