package com.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "person")
public class PersonEntity {
    //nombre-apellido-fechanac localdate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private  String lastname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "personEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProfessionEntity> professions;

    @OneToMany(mappedBy = "personEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<LanguageEntity> languages;

    @OneToMany(mappedBy = "personEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<UserEntity> usernames;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "doc_type_fk")
    private DocumentEntity docType;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<ProfessionEntity> getProfessions() {
        return professions;
    }

    public void setProfessions(List<ProfessionEntity> professions) {
        this.professions = professions;
    }

    public List<LanguageEntity> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageEntity> languages) {
        this.languages = languages;
    }

    public List<UserEntity> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<UserEntity> usernames) {
        this.usernames = usernames;
    }

    public DocumentEntity getDocType() {
        return docType;
    }

    public void setDocType(DocumentEntity docType) {
        this.docType = docType;
    }

}
////1 persona va a tener profesiones
////1 persona puede tener idiomas
////crear tabla usuario
////usuario va a tener username password asociado a una persona*****
////cada tabla de profesiones va a tener su id y su descripcion(ing-prof-dr)
////cada tabla de idioma tendra id - descripcion(eng-frn-rs-al)
////repository-service de c/u + test***
////cada persona debe tener 1 tipo de documento dni ce pasaport le***
////many2many idiomas - profesiones-----no