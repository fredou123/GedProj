package com.ged.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.repository.TypeDossierTypeMetadonneeRepository;
import com.ged.service.DtoMetier;
import com.ged.service.TypeDossierMetier;
import com.ged.service.TypeDossierTypeMetadonneeMetier;
import com.ged.service.TypeMetadonneeMetier;

@Service
public class TypeDossierTypeMetadonneeServiceImpl implements TypeDossierTypeMetadonneeMetier{
	
	@Autowired
	private TypeDossierTypeMetadonneeRepository repository;
	@Autowired
	private DtoMetier dto;
	@Override
	public TypeDossierTypeMetadonneeDTO saveTypeDossierTypeMetadonnee(
			TypeDossierTypeMetadonneeDTO value) {
		TypeDossierTypeMetadonnee t = dto.transformTypeDossierTypeMetadonnee(value);
		
	
		t =  repository.save(t);
		TypeDossierTypeMetadonneeDTO mDTO = new TypeDossierTypeMetadonneeDTO(t);
		return mDTO;
	}

	@Override
	public TypeDossierTypeMetadonnee getTypeDossierTypeMetadonnee(Long id) {
		
		return repository.findOne(id);
	}

	@Override
	public List<TypeDossierTypeMetadonneeDTO> getAllTypeDossierTypeMetadonnee() {
		Collection<TypeDossierTypeMetadonnee> allType = repository.findAll();
		List<TypeDossierTypeMetadonneeDTO> list = new ArrayList<TypeDossierTypeMetadonneeDTO>();
		for (TypeDossierTypeMetadonnee t : allType){
			list.add(new TypeDossierTypeMetadonneeDTO(t));
		}
		return list;
	}

	@Override
	public TypeDossierTypeMetadonnee deleteTypeDossierTypeMetadonnee(
			TypeDossierTypeMetadonnee t) {
		System.out.println(t.getDefaultValue());
		System.out.println(t.getId());
		repository.delete(t);
		return t;
	}

	@Override
	public List<TypeDossierTypeMetadonnee> getListByIds(Collection<Long> ids) {
		return repository.findAll(ids);
	}

}
