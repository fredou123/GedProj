package com.ged.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.ged.entities.TypeDocument;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.entities.User;

public class TypeDocumentPostDTO {
	
	private Long                       id;
    private String                     nom;
    private String statut;
    private Collection<TypeDocumentTypeMetadonneeDTO> typeDocumentTypeMetadonnees = new ArrayList<TypeDocumentTypeMetadonneeDTO>();
    private Collection<TypeDossierTypeDocumentDTO> typeDossierTypeDocuments = new ArrayList<TypeDossierTypeDocumentDTO>();
    private Date date_creation;
    private Date date_last_modification;
    private User user_creation;
    private User user_last_modification;
    
    public TypeDocumentPostDTO(TypeDocument typeDocument) {
		this.id = typeDocument.getId();
		this.nom = typeDocument.getNom();
		this.statut = typeDocument.getStatut();
		this.date_creation = typeDocument.getDate_creation();
		this.date_last_modification = typeDocument.getDate_last_modification();
		this.user_creation = typeDocument.getUser_creation();
		this.user_last_modification = typeDocument.getUser_last_modification();
		for (TypeDocumentTypeMetadonnee  t : typeDocument.getTypeDocumentTypeMetadonnees()){
			TypeDocumentTypeMetadonneeDTO tDto = new TypeDocumentTypeMetadonneeDTO();
			tDto.setId(t.getId());
			tDto.setDefaultValue(t.getDefaultValue());
			tDto.setIsObligatoire(t.getIsObligatoire());
			tDto.setRegex(t.getRegex());
			tDto.setTypeDocument(t.getTypeDocument().getId());
			tDto.setTypeMetadonnee(t.getTypeMetadonnee().getId());
			this.typeDocumentTypeMetadonnees.add(tDto);
		}
		for(TypeDossierTypeDocument t : typeDocument.getTypeDossierTypeDocuments()){
			TypeDossierTypeDocumentDTO tDto = new TypeDossierTypeDocumentDTO();
			tDto.setId(t.getId());
			tDto.setIsObligatoire(t.getIsObligatoire());
			tDto.setTypeDocument(t.getTypeDocument().getId());
			tDto.setTypeDossier(t.getTypeDossier().getId());
			this.typeDossierTypeDocuments.add(tDto);
		}
		
	}
    
	public TypeDocumentPostDTO() {
		super();
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
	
	

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Collection<TypeDocumentTypeMetadonneeDTO> getTypeDocumentTypeMetadonnees() {
		return typeDocumentTypeMetadonnees;
	}

	public void setTypeDocumentTypeMetadonnees(
			Collection<TypeDocumentTypeMetadonneeDTO> typeDocumentTypeMetadonnees) {
		this.typeDocumentTypeMetadonnees = typeDocumentTypeMetadonnees;
	}

	public Collection<TypeDossierTypeDocumentDTO> getTypeDossierTypeDocuments() {
		return typeDossierTypeDocuments;
	}

	public void setTypeDossierTypeDocuments(
			Collection<TypeDossierTypeDocumentDTO> typeDossierTypeDocuments) {
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
