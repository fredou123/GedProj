package com.ged.metier;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.entities.TypeDossierTypeDocument;

public interface TypeDossierTypeDocumentMetier {
	public TypeDossierTypeDocumentDTO saveTypeDossierTypeDocument(TypeDossierTypeDocumentDTO value);
	public TypeDossierTypeDocument getTypeDossierTypeDocument (Long id);
	public List<TypeDossierTypeDocument> getByIds (Collection<Long> ids);
	public List<TypeDossierTypeDocumentDTO> getAllTypeDossierTypeDocument();
	public TypeDossierTypeDocument deleteTypeDossierTypeDocument (TypeDossierTypeDocument t);
}
