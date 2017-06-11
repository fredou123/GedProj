package com.ged.service;

import java.util.Collection;
import java.util.List;

import com.ged.entities.TypeDossierTypeDocument;

public interface TypeDossierTypeDocumentService {
	public TypeDossierTypeDocument saveTypeDossierTypeDocument(TypeDossierTypeDocument value);
	public TypeDossierTypeDocument getTypeDossierTypeDocument (Long id);
	public List<TypeDossierTypeDocument> getByIds (Collection<Long> ids);
	public List<TypeDossierTypeDocument> getAllTypeDossierTypeDocument();
	public TypeDossierTypeDocument deleteTypeDossierTypeDocument (TypeDossierTypeDocument t);
}
