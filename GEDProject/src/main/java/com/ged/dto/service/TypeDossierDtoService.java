package com.ged.dto.service;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDossierDTO;
import com.ged.dto.TypeDossierPostDTO;

public interface TypeDossierDtoService {
	
	public TypeDossierDTO getTypeDossier(Long id);
	public TypeDossierPostDTO saveTypeDossier(TypeDossierPostDTO typeDocument);
	public List<TypeDossierDTO> getAllTypeDossiers();
	public TypeDossierDTO deleteTypeDossier(TypeDossierDTO typeDossierDto);
	public void SetTypeDossierById (String nom,Long id);
	public Collection<TypeDossierDTO> getListTypeDossierById(Collection<Long> ids);
	public void deleteSelectedTypeDossier(Collection<TypeDossierDTO> c);

}
