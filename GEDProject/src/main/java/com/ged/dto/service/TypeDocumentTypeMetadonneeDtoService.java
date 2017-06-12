package com.ged.dto.service;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDocumentTypeMetadonneeDTO;

public interface TypeDocumentTypeMetadonneeDtoService {
	
	public TypeDocumentTypeMetadonneeDTO saveTypeDocumentTypeMetadonnee(TypeDocumentTypeMetadonneeDTO value);
	public List<TypeDocumentTypeMetadonneeDTO> getAllTypeDocumentTypeMetadonnee();
	public TypeDocumentTypeMetadonneeDTO getTypeDocumentTypeMetadonnee (Long id);
	public List<TypeDocumentTypeMetadonneeDTO> getListById(Collection<Long> ids);
	public TypeDocumentTypeMetadonneeDTO deleteTypeDocumentTypeMetadonnee(TypeDocumentTypeMetadonneeDTO t);

}
