package com.ged.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ged.entities.TypeDossier;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.entities.User;

@Component
public class TypeDossierDTO {
	
	private Long                       id;
    private String                     nom;
    private Date date_creation;
    private Date date_last_modification;
    private User user_creation;
    private User user_last_modification;

    private Collection<Long> typeDossierTypeMetadonnees = new ArrayList<Long>();
    private Collection<Long> typeDossierTypeDocuments = new ArrayList<Long>();
    
    
	public TypeDossierDTO() {
		super();
	}
	
	public TypeDossierDTO(TypeDossier typeDossier) {
		this.id = typeDossier.getId();
		this.nom =typeDossier.getNom();
		for (TypeDossierTypeMetadonnee t : typeDossier.getTypeDossierTypeMetadonnees()){
			this.typeDossierTypeMetadonnees.add(t.getId());
		}
		for(TypeDossierTypeDocument t : typeDossier.getTypeDossierTypeDocuments()){
			this.typeDossierTypeDocuments.add(t.getId());
		}
		
		this.date_creation = typeDossier.getDate_creation();
		this.date_last_modification = typeDossier.getDate_last_modification();
		this.user_creation = typeDossier.getUser_creation();
		this.user_last_modification = typeDossier.getUser_last_modification();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Long> getTypeDossierTypeMetadonnees() {
		return typeDossierTypeMetadonnees;
	}
	public void setTypeDossierTypeMetadonnees(
			Collection<Long> typeDossierTypeMetadonnees) {
		this.typeDossierTypeMetadonnees = typeDossierTypeMetadonnees;
	}
	public Collection<Long> getTypeDossierTypeDocuments() {
		return typeDossierTypeDocuments;
	}
	public void setTypeDossierTypeDocuments(
			Collection<Long> typeDossierTypeDocuments) {
		this.typeDossierTypeDocuments = typeDossierTypeDocuments;
	}
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
    
    

}
