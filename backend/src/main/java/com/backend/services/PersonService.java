package com.backend.services;

import com.backend.entity.PersonEntity;
import com.backend.repository.PersonRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void save (PersonEntity personEntity){
        personRepository.save(personEntity);
    }

    public Optional<PersonEntity> findById(Long id){
        return personRepository.findById(id);
    }
    public List<PersonEntity> findAll(){
        return IterableUtils.toList(personRepository.findAll());
    }

    @Transactional
    public void changeBirthdate(Long id, LocalDate birthdate){
        personRepository.changeBirthdate(id, birthdate);
    }

    @Transactional
    public void changeBirthdate2(Long id, LocalDate birthdate){
        personRepository.findById(id).ifPresent(personEntity -> {
            personEntity.setBirthdate(birthdate);
            personRepository.save(personEntity);
        });
    }

    /*
    @Transactional
    public void changeBirthdate2(Long id, LocalDate birthdate){
        Optional<PersonEntity> optional = personRepository.findById(id);
        optional.ifPresent(personEntity -> {
            personEntity.setBirthdate(birthdate);
            personRepository.save(personEntity);
        });
    }
     */
}
