package com.ged.dto.service;

import java.util.Collection;
import java.util.List;

import com.ged.dto.TypeMetadonneeDTO;
import com.ged.dto.TypeMetadonneePostDTO;

public interface TypeMetadonneeDtoService {
	
	public TypeMetadonneeDTO getTypeMetadonnee(Long id);
	public TypeMetadonneePostDTO saveTypeMetadonnee(TypeMetadonneePostDTO typeMetadonnee);
	public List<TypeMetadonneeDTO> getAllTypeMetadonnees();
	public TypeMetadonneeDTO deleteTypeMetadonnee(TypeMetadonneeDTO typeMetadonneeDto);
	public void SetTypeMetadonneeById (String nom,Long id);
	public Collection<TypeMetadonneeDTO> getListTypeMetadonneeById(Collection<Long> ids);
	public void deleteSelectedTypeMetadonnee(Collection<TypeMetadonneeDTO> c);

}
