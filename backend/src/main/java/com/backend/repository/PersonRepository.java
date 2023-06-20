package com.backend.repository;

import com.backend.entity.PersonEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends CrudRepository<PersonEntity, Long>{
// @Modifying
//    @Query("UPDATE Person o SET o.enabled = :enabled WHERE o.id = :id")
//    void setEnabled(Long id, Boolean enabled);

        @Modifying
        @Query("Update PersonEntity p set p.birthdate= :birthdate Where p.id = :id")
        void changeBirthdate(Long id, LocalDate birthdate);

        @Query("select p from PersonEntity p inner join fetch p.docType doc")
        List<PersonEntity> personWithDoc();

        @Query("select p from PersonEntity p inner join fetch p.languages lan")
        List<PersonEntity> personWithLanguage();

        @Query("select p from PersonEntity p inner join fetch p.professions")
        List<PersonEntity> personWithProfession();

        @Query("select p from PersonEntity p inner join fetch p.usernames")
        List<PersonEntity> personWithUser();

        @Query("select p from PersonEntity p left join fetch p.professions prof")
        List<PersonEntity> personWithProfLan();
        @Query("select p from PersonEntity p left join fetch p.languages lan where p in :personas")
        List<PersonEntity> personWithProfLan1(List<PersonEntity> personas);

        @Query("select p from PersonEntity p left join fetch p.docType doc")
        List<PersonEntity>personWithAllInformation();
        @Query("select p from PersonEntity p left join fetch p.languages lan where p in :personas")
        List<PersonEntity>personWithAllInformation1(List<PersonEntity> personas);
        @Query("select p from PersonEntity p left join fetch p.professions prof where p in :personas")
        List<PersonEntity>personWithAllInformation2(List<PersonEntity> personas);
        @Query("select p from PersonEntity p left join  fetch p.usernames user where p in :personas")
        List<PersonEntity>personWithAllInformation3(List<PersonEntity> personas);


}
