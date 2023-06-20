package com.backend.repository;

import com.backend.entity.LanguageEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<LanguageEntity, Long> {
    @Modifying
    @Query("UPDATE LanguageEntity lang SET lang.personEntity = NULL WHERE lang.personEntity.id = :id")
    void clearLangPerson(Long id);
}
