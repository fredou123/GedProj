package com.ged.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Metadonnee implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long           id;
    private String         nom;
    @ManyToOne
    @JoinColumn
    private Document       document;
    @JoinColumn
    @ManyToOne
    private Dossier        dossier;
    @JoinColumn( name = "type_metadonnee" )
    @ManyToOne
    private TypeMetadonnee typeMetadonnee;

    public Document getDocument() {
        return document;
    }

    public void setDocument( Document document ) {
        this.document = document;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier( Dossier dossier ) {
        this.dossier = dossier;
    }

    public TypeMetadonnee getTypeMetadonnee() {
        return typeMetadonnee;
    }

    public void setTypeMetadonnee( TypeMetadonnee typeMetadonnee ) {
        this.typeMetadonnee = typeMetadonnee;
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

    public Metadonnee() {
        // TODO Auto-generated constructor stub
    }

}
