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
public class Groupe implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long             id;
    private String           nom;
    @ManyToMany( mappedBy = "groupes" )
    private Collection<User> users;

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

    public Groupe() {
        // TODO Auto-generated constructor stub
    }

}
