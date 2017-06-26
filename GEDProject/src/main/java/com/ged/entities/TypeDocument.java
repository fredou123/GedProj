package com.ged.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class TypeDocument implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long                       id;
    private String                     nom;
    private String statut;
    @ManyToMany( mappedBy = "typeDocuments" )
    private Collection<Profil>         profils;
    @OneToMany( mappedBy = "typeDocument" )
    private Collection<Document>       documents;
    @OneToMany (mappedBy="typeDocument", fetch=FetchType.LAZY)
    private Collection<TypeDocumentTypeMetadonnee> typeDocumentTypeMetadonnees;
    @OneToMany (mappedBy="typeDocument", fetch=FetchType.LAZY)   
    private Collection<TypeDossierTypeDocument> typeDossierTypeDocuments;
    private Date date_creation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_last_modification;
    private User user_creation;
    private User user_last_modification;


    public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_last_modification() {
		return date_last_modification;
	}

	public void setDate_last_modification(Date date_last_modification) {
		this.date_last_modification = date_last_modification;
	}

	public User getUser_creation() {
		return user_creation;
	}

	public void setUser_creation(User user_creation) {
		this.user_creation = user_creation;
	}

	public User getUser_last_modification() {
		return user_last_modification;
	}

	public void setUser_last_modification(User user_last_modification) {
		this.user_last_modification = user_last_modification;
	}
	
	public Collection<TypeDossierTypeDocument> getTypeDossierTypeDocuments() {
		return typeDossierTypeDocuments;
	}
	
	public void setTypeDossierTypeDocuments(
			Collection<TypeDossierTypeDocument> typeDossierTypeDocuments) {
		this.typeDossierTypeDocuments = typeDossierTypeDocuments;
	}

	public Collection<Profil> getProfils() {
        return profils;
    }

    public void setProfils( Collection<Profil> profils ) {
        this.profils = profils;
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments( Collection<Document> documents ) {
        this.documents = documents;
    }
    
	public Collection<TypeDocumentTypeMetadonnee> getTypeDocumentTypeMetadonnees() {
		return typeDocumentTypeMetadonnees;
	}
	public void setTypeDocumentTypeMetadonnees(
			Collection<TypeDocumentTypeMetadonnee> typeDocumentTypeMetadonnees) {
		this.typeDocumentTypeMetadonnees = typeDocumentTypeMetadonnees;
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

    public TypeDocument() {
        // TODO Auto-generated constructor stub
    }

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
    
    

}
