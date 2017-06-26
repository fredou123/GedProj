package com.ged.service.implementation;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dao.TypeMetadonneeRepository;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.entities.TypeMetadonnee;
import com.ged.service.TypeDocumentTypeMetadonneeService;
import com.ged.service.TypeDossierTypeMetadonneeService;
import com.ged.service.TypeMetadonneeService;

@Service
@Transactional
public class TypeMetadonneeServiceImpl implements TypeMetadonneeService {
	
	@Autowired
	private TypeMetadonneeRepository repository;
	@Autowired
	private TypeDossierTypeMetadonneeService metierDos;
	@Autowired
	private TypeDocumentTypeMetadonneeService metierDoc;

	@Override
	public TypeMetadonnee getTypeMetadonnee(Long id) {
		 return repository.findOne(id);
	}
	
	@Override
	public TypeMetadonnee saveTypeMetadonnee(TypeMetadonnee d) {
		d.setDate_creation(new Date()); 
		d.setDate_last_modification(new Date());
		repository.save(d);
		
		
		for (TypeDossierTypeMetadonnee t: d.getTypeDossierTypeMetadonnees()){
			t.setTypeMetadonnee(d);
			metierDos.saveTypeDossierTypeMetadonnee(t);
		}
		
		for (TypeDocumentTypeMetadonnee t: d.getTypeDocumentTypeMetadonnees()){
			t.setTypeMetadonnee(d);
			metierDoc.saveTypeDocumentTypeMetadonnee(t);
		}
		
		return d;
	}

	@Override
	public TypeMetadonnee deleteTypeMetadonnee(TypeMetadonnee typeMetadonnee) {

		if (typeMetadonnee.getTypeDossierTypeMetadonnees()!=null){
		for (TypeDossierTypeMetadonnee t: typeMetadonnee.getTypeDossierTypeMetadonnees()){
			metierDos.deleteTypeDossierTypeMetadonnee(t);
		}
		typeMetadonnee.setTypeDossierTypeMetadonnees(null);
		}
		if(typeMetadonnee.getTypeDocumentTypeMetadonnees()!=null){
		for (TypeDocumentTypeMetadonnee t: typeMetadonnee.getTypeDocumentTypeMetadonnees()){
			metierDoc.deleteTypeDocumentTypeMetadonnee(t);
		}
		typeMetadonnee.setTypeDocumentTypeMetadonnees(null);
		}
		 repository.delete(typeMetadonnee);
		 return typeMetadonnee;
	}

	@Override
	public List<TypeMetadonnee> getAllTypeMetadonnees() {		
		return repository.findAll();
	}

	@Override
	@Transactional
	public void SetTypeMetadonneeById(String nom,String type,Long id) {		
		getTypeMetadonnee(id).setDate_last_modification(new Date());
		repository.SetTypeMetadonneeById(nom, type,id);
	}

	@Override
	public void deleteSelectedTypeMetadonnee(Collection<TypeMetadonnee> c) {
		
		for (TypeMetadonnee t : c){
			deleteTypeMetadonnee(t);
		}
		
	}

	@Override
	public Collection<TypeMetadonnee> getListTypeMetadonneeById(
			Collection<Long> ids) {
		
		return repository.findAll(ids);
	}


}
