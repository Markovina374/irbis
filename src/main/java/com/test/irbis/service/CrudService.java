package com.test.irbis.service;

import com.test.irbis.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
public abstract class CrudService<E extends Model> {
  private final JpaRepository<E, Long> repository;

  public E create(E element) throws Exception {
    if (isElementExist(element)) {
      throw new Exception("Такой элемент уже существует!");
    }
    repository.save(element);
    return element;
  }

  public boolean isElementExist(E element) {
    return element.getId() != null && repository.findById(element.getId()).isPresent();
  }

  public List<E> readAll() {
    return repository.findAll();
  }

  public E readById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NullPointerException("Такого элемента не найдено"));
  }

  public E update(E element) throws Exception {
    if (isElementExist(element)){
      repository.save(element);
    }else {
      throw new Exception("Такого объекта не существует!");
    }
    return element;
  }

  public boolean delete(E element) {
    if (isElementExist(element)) {
      repository.delete(element);
      return true;
    } else {
      return false;
    }
  }
}
