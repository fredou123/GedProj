package com.ged.service;

import java.util.Collection;
import java.util.List;

import com.ged.entities.TypeDocumentTypeMetadonnee;

public interface TypeDocumentTypeMetadonneeService {
	public TypeDocumentTypeMetadonnee saveTypeDocumentTypeMetadonnee(TypeDocumentTypeMetadonnee value);
	public TypeDocumentTypeMetadonnee getTypeDocumentTypeMetadonnee (Long id);
	public List<TypeDocumentTypeMetadonnee> getListById(Collection<Long> ids);
	public List<TypeDocumentTypeMetadonnee> getAllTypeDocumentTypeMetadonnee();
	public TypeDocumentTypeMetadonnee deleteTypeDocumentTypeMetadonnee(TypeDocumentTypeMetadonnee t);
	
}
