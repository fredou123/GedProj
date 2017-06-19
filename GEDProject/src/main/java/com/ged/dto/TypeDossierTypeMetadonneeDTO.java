package com.ged.dto;

import org.springframework.stereotype.Component;

import com.ged.entities.TypeDossierTypeMetadonnee;

@Component
public class TypeDossierTypeMetadonneeDTO {
	
	private Long id;
	private Boolean isObligatoire;
	private String regex;
	private String defaultValue;
	private Long typeMetadonnee ;
	private Long typeDossier ;
	
	
	public TypeDossierTypeMetadonneeDTO() {
		super();
	}
	
	
	public TypeDossierTypeMetadonneeDTO(TypeDossierTypeMetadonnee type) {
		super();
		this.id = type.getId();
		this.isObligatoire = type.getIsObligatoire();
		this.regex = type.getRegex();
		this.defaultValue = type.getDefaultValue();
		
		if(type.getTypeMetadonnee()!=null){
			this.typeMetadonnee = type.getTypeMetadonnee().getId();
		}
		if (type.getTypeDossier()!=null){
			this.typeDossier = type.getTypeDossier().getId();
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
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Long getTypeMetadonnee() {
		return typeMetadonnee;
	}
	public void setTypeMetadonnee(Long typeMetadonnee) {
		this.typeMetadonnee = typeMetadonnee;
	}
	public Long getTypeDossier() {
		return typeDossier;
	}
	public void setTypeDossier(Long typeDossier) {
		this.typeDossier = typeDossier;
	}
	
	
	
	

}
