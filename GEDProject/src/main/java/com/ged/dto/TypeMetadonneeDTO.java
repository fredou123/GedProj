package com.ged.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.entities.TypeMetadonnee;
import com.ged.entities.User;

@Component
public class TypeMetadonneeDTO {
	
	 
	    private Long                     id;
	    private String                   nom;
	    private String type;
	    
	    private Collection<Long> typeDossierTypeMetadonnees = new ArrayList<Long>();
	    private Collection<Long> typeDocumentTypeMetadonnees = new ArrayList<Long>();
	    private Date date_creation;
	    private Date date_last_modification;
	    private User user_creation;
	    private User user_last_modification;
	    
	    
		public TypeMetadonneeDTO() {
			super();
		}
		
		public TypeMetadonneeDTO(TypeMetadonnee typeMetadonnee) {
			this.id = typeMetadonnee.getId();
			this.nom = typeMetadonnee.getNom();
			this.type = typeMetadonnee.getType();
			
			if (typeMetadonnee.getTypeDocumentTypeMetadonnees()!=null){
			for (TypeDocumentTypeMetadonnee t : typeMetadonnee.getTypeDocumentTypeMetadonnees()){
				this.typeDocumentTypeMetadonnees.add(t.getId());
			}
			}
			if(typeMetadonnee.getTypeDossierTypeMetadonnees()!=null){
			for(TypeDossierTypeMetadonnee t : typeMetadonnee.getTypeDossierTypeMetadonnees()){
				this.typeDossierTypeMetadonnees.add(t.getId());
			}
			}
			
			this.date_creation = typeMetadonnee.getDate_creation();
			this.date_last_modification = typeMetadonnee.getDate_last_modification();
			this.user_creation = typeMetadonnee.getUser_creation();
			this.user_last_modification = typeMetadonnee.getUser_last_modification();
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
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Collection<Long> getTypeDossierTypeMetadonnees() {
			return typeDossierTypeMetadonnees;
		}
		public void setTypeDossierTypeMetadonnees(
				Collection<Long> typeDossierTypeMetadonnees) {
			this.typeDossierTypeMetadonnees = typeDossierTypeMetadonnees;
		}
		public Collection<Long> getTypeDocumentTypeMetadonnees() {
			return typeDocumentTypeMetadonnees;
		}
		public void setTypeDocumentTypeMetadonnees(
				Collection<Long> typeDocumentTypeMetadonnees) {
			this.typeDocumentTypeMetadonnees = typeDocumentTypeMetadonnees;
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
