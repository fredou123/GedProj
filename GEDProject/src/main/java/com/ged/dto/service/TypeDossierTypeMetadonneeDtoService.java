package com.ged.dto.service;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDossierTypeMetadonneeDTO;

public interface TypeDossierTypeMetadonneeDtoService {
	
	public TypeDossierTypeMetadonneeDTO saveTypeDossierTypeMetadonnee(TypeDossierTypeMetadonneeDTO value);
	public List<TypeDossierTypeMetadonneeDTO> getAllTypeDossierTypeMetadonnee();
	public TypeDossierTypeMetadonneeDTO getTypeDossierTypeMetadonnee (Long id);
	public List<TypeDossierTypeMetadonneeDTO> getListById(Collection<Long> ids);
	public TypeDossierTypeMetadonneeDTO deleteTypeDossierTypeMetadonnee(TypeDossierTypeMetadonneeDTO t);


}
