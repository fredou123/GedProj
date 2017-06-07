package com.ged.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class DossierDocument implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String defaultValue;
	private TypeDossierTypeDocument typeDossierTypeDocument;
	@ManyToOne
	private Dossier dossier;
	@ManyToOne
	private Document document;
	
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public TypeDossierTypeDocument getTypeDossierTypeDocument() {
		return typeDossierTypeDocument;
	}
	public void setTypeDossierTypeDocument(
			TypeDossierTypeDocument typeDossierTypeDocument) {
		this.typeDossierTypeDocument = typeDossierTypeDocument;
	}
	public DossierDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
