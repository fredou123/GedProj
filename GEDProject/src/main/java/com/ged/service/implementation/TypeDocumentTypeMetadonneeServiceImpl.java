package com.ged.service.implementation;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.dao.TypeDocumentTypeMetadonneeRepository;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.service.TypeDocumentService;
import com.ged.service.TypeDocumentTypeMetadonneeService;
import com.ged.service.TypeMetadonneeService;

@Service
public class TypeDocumentTypeMetadonneeServiceImpl implements TypeDocumentTypeMetadonneeService{
	
	@Autowired
	private TypeDocumentTypeMetadonneeRepository repository;
	@Autowired
	private TypeDocumentService doc;
	@Autowired
	private TypeMetadonneeService meta;

	@Override
	public TypeDocumentTypeMetadonnee saveTypeDocumentTypeMetadonnee(
			TypeDocumentTypeMetadonnee value) {
		
		return repository.save(value);	
			 
	}

	@Override
	public TypeDocumentTypeMetadonnee getTypeDocumentTypeMetadonnee(Long id) {
		
		return repository.getOne(id);
	}

	@Override
	public List<TypeDocumentTypeMetadonnee> getAllTypeDocumentTypeMetadonnee() {
		return repository.findAll();
	}

	@Override
	public TypeDocumentTypeMetadonnee deleteTypeDocumentTypeMetadonnee(
			TypeDocumentTypeMetadonnee t) {
		
		repository.delete(t);
		return t;
	}

	@Override
	public List<TypeDocumentTypeMetadonnee> getListById(Collection<Long> ids) {
		return repository.findAll(ids);
	}

}
