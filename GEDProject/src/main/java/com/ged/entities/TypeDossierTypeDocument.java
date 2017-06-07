package com.ged.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class TypeDossierTypeDocument implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean isObligatoire;
	@ManyToOne
	private TypeDossier typeDossier;
	@ManyToOne
	private TypeDocument typeDocument;
	
	public Boolean getIsObligatoire() {
		return isObligatoire;
	}
	public void setIsObligatoire(Boolean isObligatoire) {
		this.isObligatoire = isObligatoire;
	}
	
	public TypeDossier getTypeDossier() {
		return typeDossier;
	}
	public void setTypeDossier(TypeDossier typeDossier) {
		this.typeDossier = typeDossier;
	}
	
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}
	public Long getId() {
		return id;
	}
	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}
	public TypeDossierTypeDocument() {
		super();
	}

}
