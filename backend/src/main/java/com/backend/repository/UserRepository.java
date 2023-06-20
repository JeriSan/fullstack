package com.backend.repository;

import com.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.w3c.dom.ls.LSException;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity,Long> {


    @Modifying
    @Query("Update UserEntity u set u.password= :password Where u.id = :id")
    void changePasswordUser(Long id, String password);

    @Query("SELECT u FROM UserEntity u left join fetch u.personEntity p ")
    List<UserEntity> selectUserWithPerson();

    @Modifying
    @Query("UPDATE UserEntity u SET u.personEntity = NULL WHERE u.personEntity.id = :id")
    void clearUserPerson(Long id);
}
