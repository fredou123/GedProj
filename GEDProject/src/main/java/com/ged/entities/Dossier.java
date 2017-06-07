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
public class Dossier implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long                   id;
    private String                 nom;
    @OneToMany (mappedBy="dossier")
    private Collection<DossierDocument> dossierDocuments;
    @OneToMany( mappedBy = "dossier" )
    private Collection<Metadonnee> metadonnees;
    @JoinColumn( name = "type_dossier" )
    @ManyToOne
    private TypeDossier            typeDossiers;

    public TypeDossier getTypeDossiers() {
        return typeDossiers;
    }

    public void setTypeDossiers( TypeDossier typeDossiers ) {
        this.typeDossiers = typeDossiers;
    }

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

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public Dossier() {
        // TODO Auto-generated constructor stub
    }

}
