package com.ged.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.repository.TypeDossierTypeDocumentRepository;
import com.ged.service.TypeDocumentMetier;
import com.ged.service.TypeDossierMetier;
import com.ged.service.TypeDossierTypeDocumentMetier;

@Service
public class TypeDossierTypeDocumentServiceImpl implements TypeDossierTypeDocumentMetier{
	
	@Autowired
	private TypeDossierTypeDocumentRepository repository;
	@Autowired
	private TypeDocumentMetier doc;
	@Autowired
	private TypeDossierMetier dos;

	@Override
	public TypeDossierTypeDocumentDTO saveTypeDossierTypeDocument(
			TypeDossierTypeDocumentDTO value) {
		TypeDossierTypeDocument t = new TypeDossierTypeDocument();
		t.setIsObligatoire(value.getIsObligatoire());
		t.setTypeDocument(doc.getTypeDocument(value.getTypeDocument()));
		t.setTypeDossier(dos.getTypeDossier(value.getTypeDossier()));
		TypeDossierTypeDocument m = new TypeDossierTypeDocument();
		m = repository.save(t);
		TypeDossierTypeDocumentDTO mDTO = new TypeDossierTypeDocumentDTO(m);
		return mDTO;
	}

	@Override
	public TypeDossierTypeDocument getTypeDossierTypeDocument(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<TypeDossierTypeDocumentDTO> getAllTypeDossierTypeDocument() {
		Collection<TypeDossierTypeDocument> allType =  repository.findAll();
		List<TypeDossierTypeDocumentDTO> list = new ArrayList<TypeDossierTypeDocumentDTO>();
		for (TypeDossierTypeDocument t : allType){
			list.add(new TypeDossierTypeDocumentDTO(t));
		}
		return list;
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
