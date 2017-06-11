package com.ged.dto.service;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDocumentDTO;
import com.ged.dto.TypeDocumentPostDTO;

public interface TypeDocumentDtoService {
	
	public TypeDocumentDTO getTypeDocument(Long id);
	public TypeDocumentPostDTO saveTypeDocument(TypeDocumentPostDTO typeDocument);
	public List<TypeDocumentDTO> getAllTypeDocuments();
	public TypeDocumentDTO deleteTypeDocument(TypeDocumentDTO typeDocumentDto);
	public void SetTypeDocumentById (String nom,Long id);
	public Collection<TypeDocumentDTO> getListTypeDocumentById(Collection<Long> ids);
	public void deleteSelectedTypeDocument(Collection<TypeDocumentDTO> c);

}
