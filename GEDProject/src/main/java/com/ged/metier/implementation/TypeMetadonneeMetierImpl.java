package com.ged.metier.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dao.TypeMetadonneeRepository;
import com.ged.dto.TypeMetadonneeDTO;
import com.ged.entities.TypeMetadonnee;
import com.ged.metier.DtoMetier;
import com.ged.metier.TypeMetadonneeMetier;

@Service
public class TypeMetadonneeMetierImpl implements TypeMetadonneeMetier {
	
	@Autowired
	private TypeMetadonneeRepository repository;
	
	private DtoMetier dto;

	@Override
	public TypeMetadonnee getTypeMetadonnee(Long id) {
		 return repository.findOne(id);
		
	}

	@Override
	public TypeMetadonneeDTO saveTypeMetadonnee(TypeMetadonneeDTO typeMetadonneeDto) {
		 dto.transformTypeMetadonneeDTO(typeMetadonneeDto);
		 
		  repository.save(dto.transformTypeMetadonneeDTO(typeMetadonneeDto));
		  return typeMetadonneeDto;
		
	}

	@Override
	public TypeMetadonnee deleteTypeMetadonnee(TypeMetadonnee typeMetadonnee) {
		 repository.delete(typeMetadonnee);
		 return typeMetadonnee;
	}

	@Override
	public List<TypeMetadonneeDTO> getAllTypeMetadonnees() {		
		Collection<TypeMetadonnee> allMetadonnees = repository.findAll();
		List<TypeMetadonneeDTO> list = new ArrayList<TypeMetadonneeDTO>();
		for (TypeMetadonnee t : allMetadonnees){
			list.add(new TypeMetadonneeDTO(t));
		}
		return list;
	}

	@Override
	@Transactional
	public void SetTypeMetadonneeById(String nom,Long id) {		
		repository.SetTypeMetadonneeById(nom, id);
	}

	@Override
	public void deleteSelectedTypeMetadonnee(Collection<TypeMetadonnee> c) {
		repository.deleteInBatch(c);
		
	}

	@Override
	public Collection<TypeMetadonnee> getListTypeMetadonneeById(
			Collection<Long> ids) {
		
		return repository.findAll(ids);
	}

}
