package com.ged.metier;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.entities.TypeDocumentTypeMetadonnee;

public interface TypeDocumentTypeMetadonneeMetier {
	public TypeDocumentTypeMetadonneeDTO saveTypeDocumentTypeMetadonnee(TypeDocumentTypeMetadonneeDTO value);
	public TypeDocumentTypeMetadonnee getTypeDocumentTypeMetadonnee (Long id);
	public List<TypeDocumentTypeMetadonnee> getListById(Collection<Long> ids);
	public List<TypeDocumentTypeMetadonneeDTO> getAllTypeDocumentTypeMetadonnee();
	public TypeDocumentTypeMetadonnee deleteTypeDocumentTypeMetadonnee(TypeDocumentTypeMetadonnee t);
	
}
