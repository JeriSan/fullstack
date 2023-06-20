package com.backend.repository;

import com.backend.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DocRepository extends CrudRepository<DocumentEntity, Long> {
}
