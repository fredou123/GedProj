package com.ged.metier;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeMetadonneeDTO;
import com.ged.entities.TypeMetadonnee;

public interface TypeMetadonneeMetier {
	
	public TypeMetadonnee getTypeMetadonnee(Long id);
	public TypeMetadonneeDTO saveTypeMetadonnee(TypeMetadonneeDTO typeMetadonnee);
	public TypeMetadonnee deleteTypeMetadonnee(TypeMetadonnee typeMetadonnee);
	public List<TypeMetadonneeDTO> getAllTypeMetadonnees();
	public void SetTypeMetadonneeById (String nom,Long id);
	public void deleteSelectedTypeMetadonnee(Collection<TypeMetadonnee> c);
	public Collection<TypeMetadonnee> getListTypeMetadonneeById(Collection<Long> ids);

}
