package com.ged.dto.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dto.TypeDocumentDTO;
import com.ged.dto.TypeDocumentPostDTO;
import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.dto.service.TypeDocumentDtoService;
import com.ged.entities.TypeDocument;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.service.TypeDocumentService;
import com.ged.service.TypeDossierService;
import com.ged.service.TypeMetadonneeService;

@Service
@Transactional
public class TypeDocumentDtoServiceIplm implements TypeDocumentDtoService {
	
	@Autowired
	private TypeDocumentService metier;
	@Autowired
	private TypeMetadonneeService metierMeta;
	@Autowired
	private TypeDossierService metierDos;

	@Override
	public TypeDocumentPostDTO saveTypeDocument(TypeDocumentPostDTO typeDocumentPostDto){
		
		TypeDocument d = new TypeDocument();
		d.setNom(typeDocumentPostDto.getNom());
		d.setDate_creation(typeDocumentPostDto.getDate_creation());
		d.setDate_last_modification(typeDocumentPostDto.getDate_last_modification());
		d.setUser_creation(typeDocumentPostDto.getUser_creation());
		d.setUser_last_modification(typeDocumentPostDto.getUser_last_modification());
		
		Collection<TypeDocumentTypeMetadonnee> c1 = new ArrayList<TypeDocumentTypeMetadonnee>();
		Collection<TypeDossierTypeDocument> c2 = new ArrayList<TypeDossierTypeDocument>();
		
		for (TypeDocumentTypeMetadonneeDTO t : typeDocumentPostDto.getTypeDocumentTypeMetadonnees()){
			TypeDocumentTypeMetadonnee m = new TypeDocumentTypeMetadonnee();
			m.setDefaultValue(t.getDefaultValue());
			m.setIsObligatoire(t.getIsObligatoire());
			m.setRegex(t.getRegex());
			m.setTypeMetadonnee(metierMeta.getTypeMetadonnee(t.getTypeMetadonnee()));
			c1.add(m);	
		}
		d.setTypeDocumentTypeMetadonnees(c1);
		
		for(TypeDossierTypeDocumentDTO t : typeDocumentPostDto.getTypeDossierTypeDocuments()){
			TypeDossierTypeDocument m = new TypeDossierTypeDocument();
			m.setIsObligatoire(t.getIsObligatoire());
			m.setTypeDossier(metierDos.getTypeDossier(t.getTypeDossier()));
			c2.add(m);
		}
		d.setTypeDossierTypeDocuments(c2);
		
		d = metier.saveTypeDocument(d);
		TypeDocumentPostDTO tDto = new TypeDocumentPostDTO(d);
		return tDto;
	}

	@Override
	public List<TypeDocumentDTO> getAllTypeDocuments() {
		Collection<TypeDocument> allDocuments =  metier.getAllTypeDocuments();
		List<TypeDocumentDTO> list = new ArrayList<TypeDocumentDTO>();
		for (TypeDocument t : allDocuments){
			list.add(new TypeDocumentDTO(t));
		}
		return list;
	}

	@Override
	public TypeDocumentDTO getTypeDocument(Long id) {
		TypeDocumentDTO tDto = new TypeDocumentDTO(metier.getTypeDocument(id));	
		return tDto;
	}

	@Override
	public TypeDocumentDTO deleteTypeDocument(TypeDocumentDTO typeDocumentDto) {
		TypeDocument d = metier.getTypeDocument(typeDocumentDto.getId());
		d = metier.deleteTypeDocument(d);
		TypeDocumentDTO tDto = new TypeDocumentDTO(d);
		return tDto;
	}

	@Override
	public void SetTypeDocumentById(String nom, Long id) {
		metier.SetTypeDocumentById(nom, id);	
	}

	@Override
	public Collection<TypeDocumentDTO> getListTypeDocumentById(
			Collection<Long> ids) {
		
		Collection<TypeDocumentDTO> documentsDto = new ArrayList<TypeDocumentDTO>();
		for (TypeDocument t : metier.getListTypeDocumentById(ids)){
			TypeDocumentDTO m = new TypeDocumentDTO(t);
			documentsDto.add(m);
		}
		return documentsDto;
	}

	@Override
	public void deleteSelectedTypeDocument(Collection<TypeDocumentDTO> c) {
		Collection<TypeDocument> documents = new ArrayList<TypeDocument>();
		for (TypeDocumentDTO t : c){
			TypeDocument d = metier.getTypeDocument(t.getId());
			documents.add(d);
		}
		metier.deleteSelectedTypeDocument(documents);
	}
	

}
