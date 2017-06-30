package com.ged.service;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.entities.TypeDossierTypeMetadonnee;

public interface TypeDossierTypeMetadonneeMetier {
	
	public TypeDossierTypeMetadonneeDTO saveTypeDossierTypeMetadonnee(TypeDossierTypeMetadonneeDTO value);
	public TypeDossierTypeMetadonnee getTypeDossierTypeMetadonnee (Long id);
	public List<TypeDossierTypeMetadonnee> getListByIds (Collection<Long> ids);
	public List<TypeDossierTypeMetadonneeDTO> getAllTypeDossierTypeMetadonnee();
	public TypeDossierTypeMetadonnee deleteTypeDossierTypeMetadonnee (TypeDossierTypeMetadonnee t);

}
