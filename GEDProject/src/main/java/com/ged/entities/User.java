package com.ged.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long                            id;
    private String                          nom;
    private String                          Prenom;
    private String                          login;
    private String                          mdp;
    @ManyToMany
    private Collection<Profil>              profils;
    @OneToMany 
    private Collection<HistoriqueConnexion> connexions;
    @ManyToMany
    private Collection<Groupe>              groupes;

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom( String prenom ) {
        Prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp( String mdp ) {
        this.mdp = mdp;
    }

    public Long getId() {
        return id;
    }

    public Collection<Profil> getProfils() {
        return profils;
    }

    public void setProfils( Collection<Profil> profils ) {
        this.profils = profils;
    }

    public Collection<HistoriqueConnexion> getConnexions() {
        return connexions;
    }

    public void setConnexions( Collection<HistoriqueConnexion> connexions ) {
        this.connexions = connexions;
    }

    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes( Collection<Groupe> groupes ) {
        this.groupes = groupes;
    }

    public User() {

    }

}
