package com.ged.service.implementation;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dao.TypeMetadonneeRepository;
import com.ged.entities.TypeMetadonnee;
import com.ged.service.TypeMetadonneeService;

@Service
@Transactional
public class TypeMetadonneeServiceImpl implements TypeMetadonneeService {
	
	@Autowired
	private TypeMetadonneeRepository repository;

	@Override
	public TypeMetadonnee getTypeMetadonnee(Long id) {
		 return repository.findOne(id);
	}
	
	@Override
	public TypeMetadonnee saveTypeMetadonnee(TypeMetadonnee d) {
		return repository.save(d);
	}

	@Override
	public TypeMetadonnee deleteTypeMetadonnee(TypeMetadonnee typeMetadonnee) {
		 repository.delete(typeMetadonnee);
		 return typeMetadonnee;
	}

	@Override
	public List<TypeMetadonnee> getAllTypeMetadonnees() {		
		return repository.findAll();
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
