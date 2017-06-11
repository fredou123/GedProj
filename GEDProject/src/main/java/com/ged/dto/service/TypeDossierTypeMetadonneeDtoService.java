package com.ged.dto.service;

import java.util.List;

import com.ged.dto.TypeDossierTypeMetadonneeDTO;

public interface TypeDossierTypeMetadonneeDtoService {
	
	public TypeDossierTypeMetadonneeDTO saveTypeDossierTypeMetadonnee(TypeDossierTypeMetadonneeDTO value);
	public List<TypeDossierTypeMetadonneeDTO> getAllTypeDossierTypeMetadonnee();

}
