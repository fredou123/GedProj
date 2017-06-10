package com.ged.service;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDocumentDTO;
import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.entities.TypeDocument;

public interface TypeDocumentService {
	
	public TypeDocument getTypeDocument(Long id);
	public TypeDocumentDTO saveTypeDocument(TypeDocumentDTO typeDocument);
	public TypeDocument deleteTypeDocument(TypeDocument typeDocument);
	public List<TypeDocumentDTO> getAllTypeDocuments();
	public void SetTypeDocumentById (String nom,Long id);
	public void deleteSelectedTypeDocument(Collection<TypeDocument> c);
	public Collection<TypeDocument> getListTypeDocumentById(Collection<Long> ids);
	public TypeDocumentDTO saveTypeDocument(TypeDocumentDTO typeDocumentDto, 
			List<TypeDocumentTypeMetadonneeDTO> listDocMeta,
			List<TypeDossierTypeDocumentDTO> listDosDoc);

}
