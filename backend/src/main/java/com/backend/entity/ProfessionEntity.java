package com.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "profession")
public class ProfessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description_profession")
    private String descriptionProfession;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "person_fk")
    @JsonBackReference
    private PersonEntity personEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionProfession() {
        return descriptionProfession;
    }

    public void setDescriptionProfession(String descriptionProfession) {
        this.descriptionProfession = descriptionProfession;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

}
