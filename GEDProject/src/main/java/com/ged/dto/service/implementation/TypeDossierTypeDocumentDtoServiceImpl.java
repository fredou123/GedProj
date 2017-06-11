package com.ged.dto.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.dto.service.TypeDossierTypeDocumentDtoService;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.service.TypeDocumentService;
import com.ged.service.TypeDossierService;
import com.ged.service.TypeDossierTypeDocumentService;

@Service
@Transactional
public class TypeDossierTypeDocumentDtoServiceImpl implements TypeDossierTypeDocumentDtoService{
	
	@Autowired
	private TypeDossierTypeDocumentService metierDosDoc;
	@Autowired
	private TypeDocumentService metierDoc;
	@Autowired
	private TypeDossierService metierDos;

	@Override
	public TypeDossierTypeDocumentDTO saveTypeDossierTypeDocument(
			TypeDossierTypeDocumentDTO value) {
		TypeDossierTypeDocument t = new TypeDossierTypeDocument();
		t.setIsObligatoire(value.getIsObligatoire());
		t.setTypeDocument(metierDoc.getTypeDocument(value.getTypeDocument()));
		t.setTypeDossier(metierDos.getTypeDossier(value.getTypeDossier()));
		t = metierDosDoc.saveTypeDossierTypeDocument(t);
		TypeDossierTypeDocumentDTO m = new TypeDossierTypeDocumentDTO(t);
		return m;
	}

	@Override
	public List<TypeDossierTypeDocumentDTO> getAllTypeDossierTypeDocument() {
		// TODO Auto-generated method stub
		return null;
	}

}
