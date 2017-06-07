package com.ged.dto;

import org.springframework.stereotype.Component;

import com.ged.entities.TypeDossierTypeDocument;

@Component
public class TypeDossierTypeDocumentDTO {
	
	private Long id;
	private Boolean isObligatoire;
	private Long typeDossier;
	private Long typeDocument;
	
	
	public TypeDossierTypeDocumentDTO() {
		super();
	}
	
	public TypeDossierTypeDocumentDTO(TypeDossierTypeDocument type) {
		
		this.id = type.getId();
		this.isObligatoire = type.getIsObligatoire();
		if (type.getTypeDossier()!=null){
			this.typeDossier = type.getTypeDossier().getId();
		}
		if (type.getTypeDocument()!=null){
			this.typeDocument = type.getTypeDocument().getId();
		}
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getIsObligatoire() {
		return isObligatoire;
	}
	public void setIsObligatoire(Boolean isObligatoire) {
		this.isObligatoire = isObligatoire;
	}
	public Long getTypeDossier() {
		return typeDossier;
	}
	public void setTypeDossier(Long typeDossier) {
		this.typeDossier = typeDossier;
	}
	public Long getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(Long typeDocument) {
		this.typeDocument = typeDocument;
	}
	
	

}
