package com.backend.services;

import com.backend.entity.*;
import com.backend.repository.*;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private DocRepository docRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfessionRepository professionRepository;


    @Transactional
    public void save (PersonEntity personEntity){
        personRepository.save(personEntity);
    }

    @Transactional
    public void saveAllInformation(PersonEntity personEntity){
        List<ProfessionEntity> professionEntities = personEntity.getProfessions();
        List<LanguageEntity> languageEntities = personEntity.getLanguages();
        List<UserEntity> userEntities = personEntity.getUsernames();
        personRepository.save(personEntity);
        if(professionEntities != null && !professionEntities.isEmpty()){
            for(ProfessionEntity prof : professionEntities){
                professionRepository.save(prof);
            }
        }else{
            professionRepository.clearByPerson(personEntity.getId());
        }
        if(languageEntities != null && !languageEntities.isEmpty()){
            for(LanguageEntity lang : languageEntities){
                languageRepository.save(lang);
            }
        }else{
            languageRepository.clearLangPerson(personEntity.getId());
        }
        if(userEntities !=null && !userEntities.isEmpty()){
            for(UserEntity user : userEntities){
                userRepository.save(user);
            }
        }else{
            userRepository.clearUserPerson(personEntity.getId());
        }


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

    public List<PersonEntity> personaConDocumento() {
        List<PersonEntity> listPerson = personRepository.personWithDoc();
        return listPerson;
    }
    public List<PersonEntity> personaConLang(){
        List<PersonEntity> listPerson = personRepository.personWithLanguage();
        return listPerson;
    }
    public List<PersonEntity> personaConProf(){
        List<PersonEntity> listPerson = personRepository.personWithProfession();
        return listPerson;
    }
    public List<PersonEntity> personaConUs(){
        List<PersonEntity> listPerson = personRepository.personWithUser();
        return listPerson;
    }

    @Transactional
    public List<PersonEntity> personaConProfLan(){
        List<PersonEntity> listPerson = personRepository.personWithProfLan();
        List<PersonEntity> listPerson1 = personRepository.personWithProfLan1(listPerson);
        return listPerson1;
    }

    @Transactional
    public List<PersonEntity> personaConTodaInformacion(){
        List<PersonEntity> listPerson = personRepository.personWithAllInformation();
        List<PersonEntity> listPerson1 = personRepository.personWithAllInformation1(listPerson);
        List<PersonEntity> listPerson2 = personRepository.personWithAllInformation2(listPerson1);
        List<PersonEntity> listPerson3 = personRepository.personWithAllInformation3(listPerson2);
        return listPerson3;
    }
}
