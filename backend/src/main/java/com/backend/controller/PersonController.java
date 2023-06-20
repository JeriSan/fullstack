package com.backend.controller;

import com.backend.entity.*;
import com.backend.services.DocService;
import com.backend.services.LanguageService;
import com.backend.services.PersonService;
import com.backend.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private DocService docService;

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private LanguageService languageService;

    @GetMapping("all")
    public List<PersonEntity> findAll(){
        return personService.findAll();
    }

    @GetMapping("byid")
    public Optional<PersonEntity> byId(Long id){
        id = 2L;
        return personService.findById(id);
    }

    @GetMapping("perdoc")
    public List<PersonEntity> perdoc(){
        return personService.personaConDocumento();
    }

    @GetMapping("perlang")
    public List<PersonEntity> perlang(){
        return personService.personaConLang();
    }

    @GetMapping("perprof")
    public List<PersonEntity> perprof(){
        return personService.personaConProf();
    }

    @GetMapping("peruser")
    public List<PersonEntity> peruser(){
        return personService.personaConUs();
    }

    @GetMapping("perall")
    public List<PersonEntity> perall(){
        List<PersonEntity> p = personService.personaConTodaInformacion();
        return p;
    }

    @PostMapping("save")
    public void save(@RequestBody PersonEntity personEntity){
        personService.saveAllInformation(personEntity);
    }

}
