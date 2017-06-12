package com.ged.dto.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
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
		
		List<TypeDossierTypeDocumentDTO> list = new ArrayList<TypeDossierTypeDocumentDTO>();
		for (TypeDossierTypeDocument t : metierDosDoc.getAllTypeDossierTypeDocument()){
			TypeDossierTypeDocumentDTO m = new TypeDossierTypeDocumentDTO(t);
			list.add(m);
		}
		return list;
	}

	@Override
	public TypeDossierTypeDocumentDTO getTypeDossierTypeDocument(Long id) {
		
		TypeDossierTypeDocument d = metierDosDoc.getTypeDossierTypeDocument(id);
		TypeDossierTypeDocumentDTO mDto = new TypeDossierTypeDocumentDTO(d);
		
		return mDto;
	}

	@Override
	public List<TypeDossierTypeDocumentDTO> getListById(Collection<Long> ids) {
		List<TypeDossierTypeDocumentDTO> cDto = new ArrayList<TypeDossierTypeDocumentDTO>();
		for (TypeDossierTypeDocument t : metierDosDoc.getByIds(ids)){
			TypeDossierTypeDocumentDTO m = new TypeDossierTypeDocumentDTO(t);
			cDto.add(m);
		}
		return cDto;
	}

	@Override
	public TypeDossierTypeDocumentDTO deleteTypeDossierTypeDocument(
			TypeDossierTypeDocumentDTO t) {
		TypeDossierTypeDocument d =  metierDosDoc.deleteTypeDossierTypeDocument(metierDosDoc.getTypeDossierTypeDocument(t.getId()));
		TypeDossierTypeDocumentDTO m = new TypeDossierTypeDocumentDTO(d);
		return m;
	}

}
