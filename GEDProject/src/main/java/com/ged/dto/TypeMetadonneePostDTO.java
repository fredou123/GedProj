package com.ged.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.entities.TypeMetadonnee;
import com.ged.entities.User;

public class TypeMetadonneePostDTO {
	
	private Long                       id;
    private String                     nom;
    private String  type;
    private Collection<TypeDocumentTypeMetadonneeDTO> typeDocumentTypeMetadonnees = new ArrayList<TypeDocumentTypeMetadonneeDTO>();
    private Collection<TypeDossierTypeMetadonneeDTO> typeDossierTypeMetadonnees = new ArrayList<TypeDossierTypeMetadonneeDTO>();
    private Date date_creation;
    private Date date_last_modification;
    private User user_creation;
    private User user_last_modification;
    
    public TypeMetadonneePostDTO(TypeMetadonnee typeMetadonnee) {
		this.id = typeMetadonnee.getId();
		this.nom = typeMetadonnee.getNom();
		this.type = typeMetadonnee.getType();
		this.date_creation = typeMetadonnee.getDate_creation();
		this.date_last_modification = typeMetadonnee.getDate_last_modification();
		this.user_creation = typeMetadonnee.getUser_creation();
		this.user_last_modification = typeMetadonnee.getUser_last_modification();
		for (TypeDocumentTypeMetadonnee  t : typeMetadonnee.getTypeDocumentTypeMetadonnees()){
			TypeDocumentTypeMetadonneeDTO tDto = new TypeDocumentTypeMetadonneeDTO();
			tDto.setId(t.getId());
			tDto.setDefaultValue(t.getDefaultValue());
			tDto.setIsObligatoire(t.getIsObligatoire());
			tDto.setRegex(t.getRegex());
			tDto.setTypeDocument(t.getTypeDocument().getId());
			tDto.setTypeMetadonnee(t.getTypeMetadonnee().getId());
			this.typeDocumentTypeMetadonnees.add(tDto);
		}
		for(TypeDossierTypeMetadonnee t : typeMetadonnee.getTypeDossierTypeMetadonnees()){
			TypeDossierTypeMetadonneeDTO tDto = new TypeDossierTypeMetadonneeDTO();
			tDto.setId(t.getId());
			tDto.setRegex(t.getRegex());
			tDto.setDefaultValue(t.getDefaultValue());
			tDto.setIsObligatoire(t.getIsObligatoire());
			tDto.setTypeMetadonnee(t.getTypeMetadonnee().getId());
			tDto.setTypeDossier(t.getTypeDossier().getId());
			this.typeDossierTypeMetadonnees.add(tDto);
		}
		
	}

	public TypeMetadonneePostDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<TypeDocumentTypeMetadonneeDTO> getTypeDocumentTypeMetadonnees() {
		return typeDocumentTypeMetadonnees;
	}

	public void setTypeDocumentTypeMetadonnees(
			Collection<TypeDocumentTypeMetadonneeDTO> typeDocumentTypeMetadonnees) {
		this.typeDocumentTypeMetadonnees = typeDocumentTypeMetadonnees;
	}

	public Collection<TypeDossierTypeMetadonneeDTO> getTypeDossierTypeMetadonnees() {
		return typeDossierTypeMetadonnees;
	}

	public void setTypeDossierTypeMetadonnees(
			Collection<TypeDossierTypeMetadonneeDTO> typeDossierTypeMetadonnees) {
		this.typeDossierTypeMetadonnees = typeDossierTypeMetadonnees;
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
