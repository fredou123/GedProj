package com.ged.metier.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dao.TypeDocumentRepository;
import com.ged.dto.TypeDocumentDTO;
import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.entities.TypeDocument;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.metier.DtoMetier;
import com.ged.metier.TypeDocumentMetier;
import com.ged.metier.TypeDocumentTypeMetadonneeMetier;
import com.ged.metier.TypeDossierTypeDocumentMetier;

@Service
public class TypeDocumentMetierImpl implements TypeDocumentMetier{
	
	@Autowired
	private TypeDocumentRepository repository;
	
	@Autowired
	private TypeDocumentTypeMetadonneeMetier metier1;
	
	@Autowired
	private TypeDossierTypeDocumentMetier metier2;
	
	@Autowired
	private DtoMetier dto;

	@Override
	public TypeDocument getTypeDocument(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public TypeDocumentDTO saveTypeDocument(TypeDocumentDTO typeDocumentDto) {
		TypeDocument d = dto.transformTypeDocumentDTO(typeDocumentDto);
		d.setDate_creation(new Date());
		d.setDate_last_modification(new Date());
		TypeDocument dBase = repository.save(d);
		if (dBase.getTypeDocumentTypeMetadonnees()!= null){
			for (TypeDocumentTypeMetadonnee t : dBase.getTypeDocumentTypeMetadonnees()){
				t.setTypeDocument(dBase);
				TypeDocumentTypeMetadonneeDTO m = new TypeDocumentTypeMetadonneeDTO(t);
				metier1.saveTypeDocumentTypeMetadonnee(m);
			}
		}
		if (d.getTypeDossierTypeDocuments()!= null){
			for (TypeDossierTypeDocument t : d.getTypeDossierTypeDocuments()){
				t.setTypeDocument(d);
				TypeDossierTypeDocumentDTO m = new TypeDossierTypeDocumentDTO(t);
				metier2.saveTypeDossierTypeDocument(m);
			}
		}
		TypeDocumentDTO dDto = new TypeDocumentDTO(dBase);
		
		return dDto;
	}
	
	@Override
	public TypeDocumentDTO saveTypeDocument(TypeDocumentDTO typeDocumentDto, 
			List<TypeDocumentTypeMetadonneeDTO> listDocMeta,
			List<TypeDossierTypeDocumentDTO> listDosDoc){
		
	/*	TypeDocument d = dto.transformTypeDocumentDTO(typeDocumentDto);
		d = repository.save(d);
		TypeDocumentDTO tDto = new TypeDocumentDTO(d);
		
		for (TypeDocumentTypeMetadonneeDTO t : listDocMeta){
			t.setTypeDocument(d.getId());
			TypeDocumentTypeMetadonneeDTO m = metier1.saveTypeDocumentTypeMetadonnee(t);
			tDto.getTypeDocumentTypeMetadonnees().add(m.getId());
		}
		for (TypeDossierTypeDocumentDTO t : listDosDoc){
			t.setTypeDocument(d.getId());
			TypeDossierTypeDocumentDTO m = metier2.saveTypeDossierTypeDocument(t);
			tDto.getTypeDossierTypeDocuments().add(m.getId());
		}
		return tDto; */
		
		return typeDocumentDto;
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
	public List<TypeDocumentDTO> getAllTypeDocuments() {
		Collection<TypeDocument> allDocuments =  repository.findAll();
		List<TypeDocumentDTO> list = new ArrayList<TypeDocumentDTO>();
		for (TypeDocument t : allDocuments){
			list.add(new TypeDocumentDTO(t));
		}
		return list;
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
