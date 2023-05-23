package com.backend.repository;

import com.backend.entity.PersonEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface PersonRepository extends CrudRepository<PersonEntity, Long>{
// @Modifying
//    @Query("UPDATE Person o SET o.enabled = :enabled WHERE o.id = :id")
//    void setEnabled(Long id, Boolean enabled);

        @Modifying
        @Query("Update PersonEntity p set p.birthdate= :birthdate Where p.id = :id")
        void changeBirthdate(Long id, LocalDate birthdate);

}
