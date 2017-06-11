package com.ged.service.implementation;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.dao.TypeDossierTypeMetadonneeRepository;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.service.TypeDossierTypeMetadonneeService;

@Service
public class TypeDossierTypeMetadonneeServiceImpl implements TypeDossierTypeMetadonneeService{
	
	@Autowired
	private TypeDossierTypeMetadonneeRepository repository;
	
	@Override
	public TypeDossierTypeMetadonnee saveTypeDossierTypeMetadonnee(
			TypeDossierTypeMetadonnee value) {
		
		value =  repository.save(value);
		
		return value;
	}

	@Override
	public TypeDossierTypeMetadonnee getTypeDossierTypeMetadonnee(Long id) {
		
		return repository.findOne(id);
	}

	@Override
	public List<TypeDossierTypeMetadonnee> getAllTypeDossierTypeMetadonnee() {
		return repository.findAll();
		
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
