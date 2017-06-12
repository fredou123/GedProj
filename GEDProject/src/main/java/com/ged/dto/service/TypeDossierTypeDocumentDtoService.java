package com.ged.dto.service;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDossierTypeDocumentDTO;

public interface TypeDossierTypeDocumentDtoService {
	
	public TypeDossierTypeDocumentDTO saveTypeDossierTypeDocument(TypeDossierTypeDocumentDTO value);
	public List<TypeDossierTypeDocumentDTO> getAllTypeDossierTypeDocument();
	public TypeDossierTypeDocumentDTO getTypeDossierTypeDocument (Long id);
	public List<TypeDossierTypeDocumentDTO> getListById(Collection<Long> ids);
	public TypeDossierTypeDocumentDTO deleteTypeDossierTypeDocument(TypeDossierTypeDocumentDTO t);

}
