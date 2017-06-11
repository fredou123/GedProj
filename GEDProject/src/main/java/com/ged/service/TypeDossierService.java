package com.ged.service;

import java.util.Collection;
import java.util.List;

import com.ged.entities.TypeDossier;

public interface TypeDossierService {
	public TypeDossier getTypeDossier(Long id);
	public TypeDossier saveTypeDossier(TypeDossier typeDossier);
	public TypeDossier deleteTypeDossier(TypeDossier typeDossier);
	public List<TypeDossier> getAllTypeDossiers();
	public void SetTypeDossierById (String nom,Long id);
	public void deleteSelectedTypeDossier(Collection<TypeDossier> c);
	public Collection<TypeDossier> getListTypeDossierById(Collection<Long> ids);
}
