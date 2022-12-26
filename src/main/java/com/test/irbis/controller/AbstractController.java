package com.test.irbis.controller;

import com.test.irbis.model.Model;
import com.test.irbis.service.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
public abstract class AbstractController<E extends Model, S extends ICrudService<E>> {
  protected final S service;

  @GetMapping("/{id}")
  public ResponseEntity<E> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.readById(id));
  }

  @PutMapping
  public ResponseEntity<E> update(@RequestBody E element) throws Exception {
    return ResponseEntity.ok(service.update(element));
  }

  @PostMapping
  public ResponseEntity<E> create(@RequestBody E element) throws Exception {
    return ResponseEntity.ok(service.create(element));
  }

  @DeleteMapping
  public ResponseEntity<Boolean> delete(@RequestBody E element) {
    return ResponseEntity.ok(service.delete(element));
  }
}
