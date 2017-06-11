package com.ged.service.implementation;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.dao.TypeDossierTypeDocumentRepository;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.service.TypeDocumentService;
import com.ged.service.TypeDossierService;
import com.ged.service.TypeDossierTypeDocumentService;

@Service
public class TypeDossierTypeDocumentServiceImpl implements TypeDossierTypeDocumentService{
	
	@Autowired
	private TypeDossierTypeDocumentRepository repository;
	@Autowired
	private TypeDocumentService doc;
	@Autowired
	private TypeDossierService dos;

	@Override
	public TypeDossierTypeDocument saveTypeDossierTypeDocument(
			TypeDossierTypeDocument value) {
		
		return repository.save(value);	
	}

	@Override
	public TypeDossierTypeDocument getTypeDossierTypeDocument(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<TypeDossierTypeDocument> getAllTypeDossierTypeDocument() {
		return  repository.findAll();
		
	}

	@Override
	public TypeDossierTypeDocument deleteTypeDossierTypeDocument(
			TypeDossierTypeDocument t) {
		repository.delete(t);
		return t;
	}

	@Override
	public List<TypeDossierTypeDocument> getByIds(Collection<Long> ids) {
		return repository.findAll(ids);
	}
}
