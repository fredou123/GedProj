package com.ged.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Document implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long                   id;
    private String                 nom;
    @OneToMany(mappedBy="document")
    private Collection<DossierDocument>    dossierDocuments;
    @OneToMany( mappedBy = "document" )
    private Collection<Metadonnee> metadonnees;
    @JoinColumn
    @ManyToOne
    private TypeDocument           typeDocument;

    public Collection<DossierDocument> getDossierDocuments() {
		return dossierDocuments;
	}

	public void setDossierDocuments(Collection<DossierDocument> dossierDocuments) {
		this.dossierDocuments = dossierDocuments;
	}

	public Collection<Metadonnee> getMetadonnees() {
        return metadonnees;
    }

    public void setMetadonnees( Collection<Metadonnee> metadonnees ) {
        this.metadonnees = metadonnees;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument( TypeDocument typeDocument ) {
        this.typeDocument = typeDocument;
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

    public Document() {
        // TODO Auto-generated constructor stub
    }

}
