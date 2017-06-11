package com.ged.service;

import java.util.Collection;
import java.util.List;

import com.ged.entities.TypeDossierTypeMetadonnee;

public interface TypeDossierTypeMetadonneeService {
	
	public TypeDossierTypeMetadonnee saveTypeDossierTypeMetadonnee(TypeDossierTypeMetadonnee t);
	public TypeDossierTypeMetadonnee getTypeDossierTypeMetadonnee (Long id);
	public List<TypeDossierTypeMetadonnee> getListByIds (Collection<Long> ids);
	public List<TypeDossierTypeMetadonnee> getAllTypeDossierTypeMetadonnee();
	public TypeDossierTypeMetadonnee deleteTypeDossierTypeMetadonnee (TypeDossierTypeMetadonnee t);

}
