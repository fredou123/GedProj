package com.ged.service.implementation;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dao.TypeDossierRepository;
import com.ged.entities.TypeDossier;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.service.TypeDossierService;
import com.ged.service.TypeDossierTypeDocumentService;
import com.ged.service.TypeDossierTypeMetadonneeService;

@Service
@Transactional
public class TypeDossierServiceImpl implements TypeDossierService {

	@Autowired
	private TypeDossierRepository repository;
	@Autowired
	private TypeDossierTypeMetadonneeService metier1;
	@Autowired
	private TypeDossierTypeDocumentService metier2;
	

	@Override
	public TypeDossier getTypeDossier(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public TypeDossier saveTypeDossier(TypeDossier typeDossier) {	
		
		 typeDossier = repository.save(typeDossier);
		
			for (TypeDossierTypeMetadonnee t : typeDossier.getTypeDossierTypeMetadonnees()){
				t.setTypeDossier(typeDossier);
				metier1.saveTypeDossierTypeMetadonnee(t);
			}
		
			for (TypeDossierTypeDocument t : typeDossier.getTypeDossierTypeDocuments()){
				t.setTypeDossier(typeDossier);
				metier2.saveTypeDossierTypeDocument(t);
			}
	
		return typeDossier;
	}

	@Override
	@Transactional
	public TypeDossier deleteTypeDossier(TypeDossier typeDossier) {
		if (typeDossier.getTypeDossierTypeDocuments()!= null){
			for (TypeDossierTypeDocument t : typeDossier.getTypeDossierTypeDocuments()){
				metier2.deleteTypeDossierTypeDocument(t);
				}
			typeDossier.setTypeDossierTypeDocuments(null);
		}
		if (typeDossier.getTypeDossierTypeMetadonnees()!= null){
			for (TypeDossierTypeMetadonnee t : typeDossier.getTypeDossierTypeMetadonnees()){
				metier1.deleteTypeDossierTypeMetadonnee(t);
			}
			typeDossier.setTypeDossierTypeMetadonnees(null);
		}
		repository.delete(typeDossier);
		return typeDossier;
	}

	@Override
	public List<TypeDossier> getAllTypeDossiers() {
		return repository.findAll();
		
	}
	
	@Override
	@Transactional
	public void SetTypeDossierById(String nom, Long id) {
		repository.SetTypeDossierById(nom, id);
		
	}

	@Override
	@Transactional
	public void deleteSelectedTypeDossier(Collection<TypeDossier> c) {
		for (TypeDossier td : c){
			this.deleteTypeDossier(td);
		}
		
	}

	@Override
	public Collection<TypeDossier> getListTypeDossierById(Collection<Long> ids) {
		return repository.findAll(ids);
	}
	
	
}
