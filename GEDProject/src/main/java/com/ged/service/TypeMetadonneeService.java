package com.ged.service;

import java.util.Collection;
import java.util.List;

import com.ged.entities.TypeMetadonnee;

public interface TypeMetadonneeService {
	
	public TypeMetadonnee getTypeMetadonnee(Long id);
	public TypeMetadonnee saveTypeMetadonnee(TypeMetadonnee d);
	public TypeMetadonnee deleteTypeMetadonnee(TypeMetadonnee typeMetadonnee);
	public List<TypeMetadonnee> getAllTypeMetadonnees();
	public void SetTypeMetadonneeById (String nom,String type,Long id);
	public void deleteSelectedTypeMetadonnee(Collection<TypeMetadonnee> c);
	public Collection<TypeMetadonnee> getListTypeMetadonneeById(Collection<Long> ids);

}
