package com.test.irbis.repository;

import com.test.irbis.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface AbstractRepository <E extends Model> extends JpaRepository<E, Long> {
}
