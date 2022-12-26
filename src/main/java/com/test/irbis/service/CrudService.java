package com.test.irbis.service;

import com.test.irbis.model.Model;
import com.test.irbis.repository.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CrudService<E extends Model, R extends AbstractRepository<E>> implements ICrudService<E> {
  protected final R repository;

  @Override
  public E create(E element) throws Exception {
    if (isElementExist(element)) {
      throw new Exception("Такой элемент уже существует!");
    }
    repository.save(element);
    return element;
  }

  @Override
  public boolean isElementExist(E element) {
    return repository.existsById(element.getId());
  }

  @Override
  public List<E> readAll() {
    return repository.findAll();
  }

  @Override
  public E readById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NullPointerException("Такого элемента не найдено"));
  }

  @Override
  public E update(E element) throws Exception {
    if (isElementExist(element)) {
      repository.save(element);
    } else {
      throw new Exception("Такого объекта не существует!");
    }
    return element;
  }

  @Override
  public boolean delete(E element) {
    if (isElementExist(element)) {
      repository.delete(element);
      return true;
    } else {
      return false;
    }
  }
}
