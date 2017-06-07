package com.ged.metier;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeDossierDTO;
import com.ged.entities.TypeDossier;

public interface TypeDossierMetier {
	public TypeDossier getTypeDossier(Long id);
	public TypeDossierDTO saveTypeDossier(TypeDossierDTO typeDossier);
	public TypeDossier deleteTypeDossier(TypeDossier typeDossier);
	public List<TypeDossierDTO> getAllTypeDossiers();
	public void SetTypeDossierById (String nom,Long id);
	public void deleteSelectedTypeDossier(Collection<TypeDossier> c);
	public Collection<TypeDossier> getListTypeDossierById(Collection<Long> ids);
}
