package com.ged.dto;

import org.springframework.stereotype.Component;

import com.ged.entities.TypeDocumentTypeMetadonnee;

@Component
public class TypeDocumentTypeMetadonneeDTO {
	
	private Long id;
	private Boolean isObligatoire;
	private String regex;
	private String defaultValue;
	private Long typeMetadonnee;
	private Long typeDocument;
	
	public TypeDocumentTypeMetadonneeDTO() {
		super();
	}
	
	public TypeDocumentTypeMetadonneeDTO(TypeDocumentTypeMetadonnee type) {
		this.id = type.getId();
		this.isObligatoire = type.getIsObligatoire();
		this.defaultValue = type.getDefaultValue();
		this.regex = type.getRegex();
		if (type.getTypeDocument()!=null){
			this.typeDocument = type.getTypeDocument().getId();
		}
		if (type.getTypeMetadonnee()!=null){
			this.typeMetadonnee = type.getTypeMetadonnee().getId();
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
	public Long getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(Long typeDocument) {
		this.typeDocument = typeDocument;
	}
	
	

}
