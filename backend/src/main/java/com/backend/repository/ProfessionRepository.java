package com.backend.repository;

import com.backend.entity.ProfessionEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ProfessionRepository extends CrudRepository<ProfessionEntity, Long> {

    @Modifying
    @Query("UPDATE ProfessionEntity p SET p.personEntity = NULL WHERE p.personEntity.id = :id")
    void clearByPerson(Long id);

}
