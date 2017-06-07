package com.ged.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class TypeDocumentTypeMetadonnee implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean isObligatoire;
	private String regex;
	private String defaultValue;
	@ManyToOne
	private TypeMetadonnee typeMetadonnee;
	@ManyToOne
	private TypeDocument typeDocument;
	
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
	
	public TypeMetadonnee getTypeMetadonnee() {
		return typeMetadonnee;
	}
	
	public void setTypeMetadonnee(TypeMetadonnee typeMetadonnee) {
		this.typeMetadonnee = typeMetadonnee;
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
	
	public TypeDocumentTypeMetadonnee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
