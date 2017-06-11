package com.ged.service.implementation;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dao.TypeDocumentRepository;
import com.ged.entities.TypeDocument;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.service.TypeDocumentService;
import com.ged.service.TypeDocumentTypeMetadonneeService;
import com.ged.service.TypeDossierTypeDocumentService;

@Service
public class TypeDocumentServiceImpl implements TypeDocumentService{
	
	@Autowired
	private TypeDocumentRepository repository;
	
	@Autowired
	private TypeDocumentTypeMetadonneeService metier1;
	
	@Autowired
	private TypeDossierTypeDocumentService metier2;
	
	@Override
	public TypeDocument getTypeDocument(Long id) {
		return repository.findOne(id);
	}
	
	@Override
	@Transactional
	public TypeDocument saveTypeDocument(TypeDocument typeDocument){
			
		typeDocument = repository.save(typeDocument);
		
		for (TypeDocumentTypeMetadonnee t : typeDocument.getTypeDocumentTypeMetadonnees()){
			t.setTypeDocument(typeDocument);
			t = metier1.saveTypeDocumentTypeMetadonnee(t);
			
		}
		for(TypeDossierTypeDocument t : typeDocument.getTypeDossierTypeDocuments()){
			t.setTypeDocument(typeDocument);
			t = metier2.saveTypeDossierTypeDocument(t);
		}
		
		return typeDocument;
	}

	@Override
	@Transactional
	public TypeDocument deleteTypeDocument(TypeDocument typeDocument) {
		
		if (typeDocument.getTypeDocumentTypeMetadonnees()!= null){
			for (TypeDocumentTypeMetadonnee t : typeDocument.getTypeDocumentTypeMetadonnees()){
				metier1.deleteTypeDocumentTypeMetadonnee(t);
				typeDocument.setTypeDocumentTypeMetadonnees(null);
			}
		}
		if (typeDocument.getTypeDossierTypeDocuments()!= null){
			for (TypeDossierTypeDocument t : typeDocument.getTypeDossierTypeDocuments()){
				metier2.deleteTypeDossierTypeDocument(t);
				typeDocument.setTypeDossierTypeDocuments(null);
			}
		}
		 repository.delete(typeDocument);
		 return typeDocument;
	}

	@Override
	public List<TypeDocument> getAllTypeDocuments() {
		return  repository.findAll();
		
	}

	@Override
	@Transactional
	public void SetTypeDocumentById(String nom, Long id) {
		repository.SetTypeDocumentById(nom, id);
		
	}

	@Override
	@Transactional
	public void deleteSelectedTypeDocument(Collection<TypeDocument> c) {
		for (TypeDocument td : c){
			deleteTypeDocument(td);
		}
		
	}

	@Override
	public Collection<TypeDocument> getListTypeDocumentById(Collection<Long> ids) {
		return repository.findAll(ids);
	}

}
