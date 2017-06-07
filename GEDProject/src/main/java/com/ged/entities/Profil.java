package com.ged.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity
public class Profil implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long                     id;
    private String                   nom;
    @ManyToMany( mappedBy = "profils" )
    private Collection<User>         users;
    @ManyToMany
    private Collection<TypeDossier>  typeDossiers;
    @ManyToMany
    private Collection<TypeDocument> typeDocuments;

    public Collection<TypeDossier> getTypeDossiers() {
        return typeDossiers;
    }

    public void setTypeDossiers( Collection<TypeDossier> typeDossiers ) {
        this.typeDossiers = typeDossiers;
    }

    public Collection<TypeDocument> getTypeDocuments() {
        return typeDocuments;
    }

    public void setTypeDocuments( Collection<TypeDocument> typeDocuments ) {
        this.typeDocuments = typeDocuments;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers( Collection<User> users ) {
        this.users = users;
    }

    public Profil() {
        // TODO Auto-generated constructor stub
    }

}
