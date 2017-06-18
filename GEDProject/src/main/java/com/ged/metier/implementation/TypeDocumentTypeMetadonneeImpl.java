package com.ged.metier.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.metier.TypeDocumentMetier;
import com.ged.metier.TypeDocumentTypeMetadonneeMetier;
import com.ged.metier.TypeMetadonneeMetier;
import com.ged.repository.TypeDocumentTypeMetadonneeRepository;

@Service
public class TypeDocumentTypeMetadonneeImpl implements TypeDocumentTypeMetadonneeMetier{
	
	@Autowired
	private TypeDocumentTypeMetadonneeRepository repository;
	@Autowired
	private TypeDocumentMetier doc;
	@Autowired
	private TypeMetadonneeMetier meta;

	@Override
	public TypeDocumentTypeMetadonneeDTO saveTypeDocumentTypeMetadonnee(
			TypeDocumentTypeMetadonneeDTO value) {
		TypeDocumentTypeMetadonnee t = new TypeDocumentTypeMetadonnee();
		t.setDefaultValue(value.getDefaultValue());
		t.setIsObligatoire(value.getIsObligatoire());
		t.setRegex(value.getRegex());
		t.setTypeDocument(doc.getTypeDocument(value.getId()));
		t.setTypeMetadonnee(meta.getTypeMetadonnee(value.getId()));
		
		TypeDocumentTypeMetadonnee m = repository.save(t);
		
		TypeDocumentTypeMetadonneeDTO mDTO = new TypeDocumentTypeMetadonneeDTO(m);
		return mDTO;
		 
	}

	@Override
	public TypeDocumentTypeMetadonnee getTypeDocumentTypeMetadonnee(Long id) {
		
		return repository.getOne(id);
	}

	@Override
	public List<TypeDocumentTypeMetadonneeDTO> getAllTypeDocumentTypeMetadonnee() {
		Collection<TypeDocumentTypeMetadonnee> allTypes = repository.findAll();
		List<TypeDocumentTypeMetadonneeDTO> list = new ArrayList<TypeDocumentTypeMetadonneeDTO>();
		for(TypeDocumentTypeMetadonnee t : allTypes){
			list.add(new TypeDocumentTypeMetadonneeDTO(t));
		}
		return list;
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
