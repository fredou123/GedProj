package com.ged.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.dto.TypeDocumentDTO;
import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.TypeDossierDTO;
import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.dto.TypeMetadonneeDTO;
import com.ged.entities.TypeDocument;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossier;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.entities.TypeMetadonnee;
import com.ged.service.DtoMetier;
import com.ged.service.TypeDocumentMetier;
import com.ged.service.TypeDocumentTypeMetadonneeMetier;
import com.ged.service.TypeDossierMetier;
import com.ged.service.TypeDossierTypeDocumentMetier;
import com.ged.service.TypeDossierTypeMetadonneeMetier;
import com.ged.service.TypeMetadonneeMetier;

@Service
public class DtoMetierImpl implements DtoMetier {
	
	@Autowired
	private TypeDocumentTypeMetadonneeMetier docMeta;
	@Autowired
	private TypeDossierTypeDocumentMetier dosDoc;
	@Autowired
	private TypeDossierTypeMetadonneeMetier dosMeta;
	@Autowired
	private TypeDossierMetier dos;
	@Autowired
	private TypeDocumentMetier doc;
	@Autowired
	private TypeMetadonneeMetier meta;
	
	@Override
	public TypeDocument transformTypeDocumentDTO (TypeDocumentDTO tDTO){
		TypeDocument t = new TypeDocument();
		t.setDate_creation(tDTO.getDate_creation());
		t.setDate_last_modification(tDTO.getDate_last_modification());
		t.setUser_creation(tDTO.getUser_creation());
		t.setUser_last_modification(tDTO.getUser_last_modification());
		t.setNom(tDTO.getNom());
		t.setTypeDocumentTypeMetadonnees(docMeta.getListById(tDTO.getTypeDocumentTypeMetadonnees()));
		t.setTypeDossierTypeDocuments(dosDoc.getByIds(tDTO.getTypeDossierTypeDocuments()));
		return t;
	}
	
	@Override
	public TypeDossier transformTypeDossierDT0 (TypeDossierDTO tDTO){
		TypeDossier t = new TypeDossier();
		t.setNom(tDTO.getNom());
		t.setDate_creation(tDTO.getDate_creation());
		t.setDate_last_modification(tDTO.getDate_last_modification());
		t.setUser_creation(tDTO.getUser_creation());
		t.setUser_last_modification(tDTO.getUser_last_modification());
		t.setTypeDossierTypeDocuments(dosDoc.getByIds(tDTO.getTypeDossierTypeDocuments()));
		t.setTypeDossierTypeMetadonnees(dosMeta.getListByIds(tDTO.getTypeDossierTypeMetadonnees()));
		return t;
	}
	
	@Override
	public TypeMetadonnee transformTypeMetadonneeDTO (TypeMetadonneeDTO tDTO){
		TypeMetadonnee t = new TypeMetadonnee();
		t.setNom(tDTO.getNom());
		t.setDate_creation(tDTO.getDate_creation());
		t.setDate_last_modification(tDTO.getDate_last_modification());
		t.setUser_creation(tDTO.getUser_creation());
		t.setUser_last_modification(tDTO.getUser_last_modification());
		t.setTypeDocumentTypeMetadonnees(docMeta.getListById(tDTO.getTypeDocumentTypeMetadonnees()));
		t.setTypeDossierTypeMetadonnees(dosMeta.getListByIds(tDTO.getTypeDossierTypeMetadonnees()));
		return t;
	}
	
	@Override
	public TypeDossierTypeMetadonnee transformTypeDossierTypeMetadonnee (TypeDossierTypeMetadonneeDTO tDTO){
		TypeDossierTypeMetadonnee m = new TypeDossierTypeMetadonnee();
		m.setDefaultValue(tDTO.getDefaultValue());
		m.setIsObligatoire(tDTO.getIsObligatoire());
		m.setRegex(tDTO.getRegex());
		m.setTypeDossier(dos.getTypeDossier(tDTO.getTypeDossier()));
		m.setTypeMetadonnee(meta.getTypeMetadonnee(tDTO.getTypeMetadonnee()));
		return m;
	}
	
	@Override
	public TypeDossierTypeDocument transformTypeDossierTypeDocument (TypeDossierTypeDocumentDTO tDTO){
		TypeDossierTypeDocument m = new TypeDossierTypeDocument();
		m.setIsObligatoire(tDTO.getIsObligatoire());
		m.setTypeDocument(doc.getTypeDocument(tDTO.getTypeDocument()));
		m.setTypeDossier(dos.getTypeDossier(tDTO.getTypeDossier()));
		return m;
	}
	
	@Override
	public TypeDocumentTypeMetadonnee transformTypeDocumentTypeMetadonnee(TypeDocumentTypeMetadonneeDTO tDTO){
		TypeDocumentTypeMetadonnee m = new TypeDocumentTypeMetadonnee();
		m.setDefaultValue(tDTO.getDefaultValue());
		m.setIsObligatoire(tDTO.getIsObligatoire());
		m.setRegex(tDTO.getRegex());
		m.setTypeDocument(doc.getTypeDocument(tDTO.getTypeDocument()));
		m.setTypeMetadonnee(meta.getTypeMetadonnee(tDTO.getTypeMetadonnee()));
		return m;
	}


}
