package com.ged.service;

import java.util.Collection;
import java.util.List;

import com.ged.entities.TypeDocument;

public interface TypeDocumentService {
	
	public TypeDocument getTypeDocument(Long id);
	public TypeDocument saveTypeDocument(TypeDocument d);
	public TypeDocument deleteTypeDocument(TypeDocument typeDocument);
	public List<TypeDocument> getAllTypeDocuments();
	public void SetTypeDocumentById (String nom,String statut,Long id);
	public void deleteSelectedTypeDocument(Collection<TypeDocument> c);
	public Collection<TypeDocument> getListTypeDocumentById(Collection<Long> ids);

}
