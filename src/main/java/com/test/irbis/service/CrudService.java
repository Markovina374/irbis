package com.test.irbis.service;

import com.test.irbis.exception.BusinessLogicException;
import com.test.irbis.exception.DbException;
import com.test.irbis.model.Model;
import com.test.irbis.repository.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * КРУДовый Супер сервис
 */
@Service
@RequiredArgsConstructor
public abstract class CrudService<E extends Model, R extends AbstractRepository<E>> implements ICrudService<E> {
  /**
   * Репозиторий
   */
  protected final R repository;

  /**
   * Метод создания нового элемента
   */
  @Override
  public E create(E element) throws BusinessLogicException {
    if (isElementExist(element)) {
      throw new BusinessLogicException("Such an element already exists!", HttpStatus.CONFLICT);
    }
    repository.save(element);
    return element;
  }

  /**
   * Проверка на существование елемента
   */
  @Override
  public boolean isElementExist(E element) {
    return repository.existsById(element.getId());
  }

  /**
   * Метод получения всех сущностей
   */
  @Override
  public List<E> readAll() {
    return repository.findAll();
  }

  /**
   * Поиск по идентифкатору сущности
   */
  @Override
  public E readById(Long id) {
    return repository.findById(id).orElseThrow(() -> new DbException("No such element found!"));
  }

  /**
   * Обновление объекта
   */
  @Override
  public E update(E element) throws DbException {
    if (isElementExist(element)) {
      repository.save(element);
    } else {
      throw new DbException("Such an element already exists!");
    }
    return element;
  }

  /**
   * Удаление объекта по идентификатру
   */
  @Override
  public boolean delete(Long elementId) {
    if (isElementExist(readById(elementId))) {
      repository.deleteById(elementId);
      return true;
    } else {
      throw new DbException("Such an element already exists!");
    }
  }
}
